package api

import (
	"database/sql"
	"log"
	"os"
	"testing"

	database "github.com/jmpfrazao/backend-services/bank-service/database/sqlc"
	_ "github.com/lib/pq"
)

var testQueries *database.Queries
var testDB *sql.DB

const (
	dbDriver = "postgres"
	dbSource = "postgresql://root:secret@localhost:5432/simple_bank?sslmode=disable"
)

func TestMain(m *testing.M) {
	var err error

	testDB, err = sql.Open(dbDriver, dbSource)

	if err != nil {
		log.Println(err)
		log.Fatal("Cannot connect to payment database ")
	}

	testQueries = database.New(testDB)

	os.Exit(m.Run())
}
