package api

import (
	"github.com/gin-gonic/gin"
	"github.com/jmpfrazao/backend-services/bank-service/api/account"
	"github.com/jmpfrazao/backend-services/bank-service/database"
)

func InitBankServiceAPI(db *database.Database) *gin.Engine {
	router := gin.Default()
	account.RegisterHandlers(&router.RouterGroup, account.NewAccountService(db))

	return router
}
