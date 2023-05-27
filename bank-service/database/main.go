package database

import (
	"database/sql"
	"fmt"
	"log"

	"github.com/jmpfrazao/backend-services/bank-service/configuration"
	"github.com/jmpfrazao/backend-services/bank-service/database/models"
	_ "github.com/lib/pq"
)

type Database struct {
	Connection *sql.DB
	Main       *models.Queries
	ReadOnly   *models.Queries
}

// add read replica
func ConnectDatabase() *Database {
	log.Println("Connect to database " + infoDB())

	dsn := fmt.Sprintf("host=%v port=%v user=%v password=%v dbname=%v sslmode=%v TimeZone=%v",
		configuration.Conf.Database.Host, configuration.Conf.Database.Port, configuration.Conf.Database.Username, configuration.Conf.Database.Password,
		configuration.Conf.Database.Name, configuration.Conf.Database.SSLMode, configuration.Conf.Database.TimeZone)

	conn, err := sql.Open("postgres", dsn)

	if err != nil {
		log.Panicf(fmt.Sprintf("Cannot Connect Database %v", err))
	}

	dbs := Database{
		Connection: conn,
		Main:       models.New(conn),
		ReadOnly:   models.New(conn), // pass read only config
	}
	return &dbs
}

func infoDB() string {
	return fmt.Sprintf("%v@%v:%v/%v?sslMode=%v&timeZone=%v",
		configuration.Conf.Database.Username, configuration.Conf.Database.Host, configuration.Conf.Database.Port, configuration.Conf.Database.Name, configuration.Conf.Database.SSLMode, configuration.Conf.Database.TimeZone)
}
