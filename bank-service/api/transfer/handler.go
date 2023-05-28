package transfer

import (
	"github.com/gin-gonic/gin"
)

type TransferHandler struct {
	accountService ITransferService
}

func RegisterHandlers(router *gin.RouterGroup, accountService ITransferService) {
	// add routes
	h := TransferHandler{
		accountService: accountService,
	}
	router.POST("/transfer", h.CreateTranfer)

}

func (h TransferHandler) CreateTranfer(ctx *gin.Context) {

	// pass view response
	h.accountService.CreateTransfer(ctx)
}
