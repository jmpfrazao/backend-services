package main

import (
	"os"
	"testing"

	database "github.com/jmpfrazao/backend-services/bank-service/database"
	_ "github.com/lib/pq"
)

var testDB *database.Database

func TestMain(m *testing.M) {

	testDB = database.ConnectDatabase()

	os.Exit(m.Run())
}
