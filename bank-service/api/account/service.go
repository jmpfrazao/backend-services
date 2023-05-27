package account

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/jmpfrazao/backend-services/bank-service/api/errors"
	"github.com/jmpfrazao/backend-services/bank-service/database"
	models "github.com/jmpfrazao/backend-services/bank-service/database/models"
)

type IAccountService interface {
	CreateAccount(ctx *gin.Context, req CreateAccountRequest)
}

type AccountService struct {
	accountRepository *database.Database
}

func NewAccountService(db *database.Database) IAccountService {
	return &AccountService{
		accountRepository: db,
	}
}

func (s *AccountService) CreateAccount(ctx *gin.Context, req CreateAccountRequest) {
	arg := models.CreateAccountParams{
		Owner:    req.Owner,
		Currency: req.Currency,
		Balance:  0,
	}

	account, err := s.accountRepository.Main.CreateAccount(ctx, arg)
	if err != nil {
		ctx.JSON(http.StatusInternalServerError, errors.ErrorResponse(err))
		return
	}

	ctx.JSON(http.StatusOK, account)
}
