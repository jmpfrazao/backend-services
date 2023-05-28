package transfer

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/jmpfrazao/backend-services/bank-service/database"
)

type ITransferService interface {
	CreateTransfer(ctx *gin.Context)
}

type AccountService struct {
	accountRepository *database.Database
}

func NewAccountService(db *database.Database) ITransferService {
	return &AccountService{
		accountRepository: db,
	}
}

func (s *AccountService) CreateTransfer(ctx *gin.Context) {
	ctx.JSON(http.StatusOK, nil)
}
