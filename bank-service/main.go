package main

import (
	"log"

	"github.com/jmpfrazao/backend-services/bank-service/api"
	"github.com/jmpfrazao/backend-services/bank-service/configuration"
	"github.com/jmpfrazao/backend-services/bank-service/database"
)

const (
	dbDriver      = "postgres"
	dbSource      = "postgresql://root:secret@localhost:5432/simple_bank?sslmode=disable"
	serverAddress = "0.0.0.0:8080"
)

func init() {
	// read env
	configuration.ReadConfiguration()
}

func main() {
	db := database.ConnectDatabase()

	server := api.InitBankServiceAPI(db)

	err := server.Run(serverAddress)

	if err != nil {
		log.Fatal("cannot start server: ", err)
	}
}
