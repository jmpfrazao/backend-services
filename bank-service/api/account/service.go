package account

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/jmpfrazao/backend-services/bank-service/api/errors"
	"github.com/jmpfrazao/backend-services/bank-service/database"
	dberrors "github.com/jmpfrazao/backend-services/bank-service/database/errors"
	models "github.com/jmpfrazao/backend-services/bank-service/database/models"
)

type IAccountService interface {
	CreateAccount(ctx *gin.Context, req CreateAccountRequest)
	GetAccountByID(ctx *gin.Context, req GetAccountByIDRequest)
	ListAccounts(ctx *gin.Context, req ListAccountsRequest)
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

func (s *AccountService) GetAccountByID(ctx *gin.Context, req GetAccountByIDRequest) {

	account, err := s.accountRepository.Main.GetAccount(ctx, req.ID)

	if dberrors.IsEmptyQueryResult(err) {
		ctx.JSON(http.StatusNotFound, errors.ErrorResponse(err))
		return
	}

	if err != nil {
		ctx.JSON(http.StatusInternalServerError, errors.ErrorResponse(err))
		return
	}

	ctx.JSON(http.StatusOK, account)
}

func (s *AccountService) ListAccounts(ctx *gin.Context, req ListAccountsRequest) {

	arg := models.ListAccountsParams{
		Limit:  int32(req.PageSize),
		Offset: (int32(req.PageID) - 1) * int32(req.PageSize),
	}
	account, err := s.accountRepository.Main.ListAccounts(ctx, arg)

	if err != nil {
		ctx.JSON(http.StatusInternalServerError, errors.ErrorResponse(err))
		return
	}

	ctx.JSON(http.StatusOK, account)
}
