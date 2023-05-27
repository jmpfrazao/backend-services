package account

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/jmpfrazao/backend-services/bank-service/api/errors"
)

type AccountHandler struct {
	accountService IAccountService
}

func RegisterHandlers(router *gin.RouterGroup, accountService IAccountService) {
	// add routes
	h := AccountHandler{
		accountService: accountService,
	}
	router.POST("/accounts", h.CreateAccount)

}

func (h AccountHandler) CreateAccount(ctx *gin.Context) {
	var req CreateAccountRequest
	if err := ctx.ShouldBindJSON(&req); err != nil {
		ctx.JSON(http.StatusBadGateway, errors.ErrorResponse(err))
		return
	}

	// pass view response
	h.accountService.CreateAccount(ctx, req)
}
