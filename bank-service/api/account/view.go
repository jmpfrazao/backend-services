package account

type CreateAccountRequest struct {
	Owner    string `json:"owner" binding:"required"`
	Currency string `json:"currency" binding:"required,oneof= USD EUR"`
}

type GetAccountByIDRequest struct {
	ID int64 `uri:"id" binding:"required,min=1"`
}
