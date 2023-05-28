package api

// import (
// 	"context"
// 	"database/sql"
// 	"fmt"
// 	"log"

// 	"github.com/jmpfrazao/backend-services/bank-service/database"
// )

// type Repository interface {
// 	Get() string
// }

// type Repository struct {
// 	database *Database
// }

// func NewRepository(db *database.DB) Repository {
// 	return &repository{db}
// }

// func NewRepository(db *sql.DB) *Repository {
// 	return &Repository{
// 		db:      db,
// 		Queries: *database.New(db),
// 	}
// }

// func (repository *Repository) execTx(ctx context.Context, fn func(*database.Queries) error) error {
// 	tx, err := repository.db.BeginTx(ctx, nil)

// 	if err != nil {
// 		return err
// 	}

// 	txQueries := database.New(tx)

// 	err = fn(txQueries)

// 	if err != nil {
// 		if rollbackError := tx.Rollback(); rollbackError != nil {
// 			return fmt.Errorf("tx err: %v, rollback err: %v", err, rollbackError)
// 		}
// 		return err
// 	}

// 	return tx.Commit()
// }

// type TransferTxParams struct {
// 	FromAccountID int64 `json:"from_account_id"`
// 	ToAccountID   int64 `json:"to_account_id"`
// 	Amount        int64 `json:"amount"`
// }

// type TransferTxResult struct {
// 	Transfer    database.Transfer `json:"tranfer"`
// 	FromAccount database.Account  `json:"from_account"`
// 	ToAccount   database.Account  `json:"to_account"`
// 	FromEntry   database.Entry    `json:"from_entry"`
// 	ToEntry     database.Entry    `json:"to_entry"`
// }

// func (repository *Repository) {

// }
// // TransferTx performs a money transfer from on account to the other.
// func (repository *Repository) TransferTx(ctx context.Context, arg TransferTxParams) (TransferTxResult, error) {
// 	var result TransferTxResult

// 	err := repository.execTx(ctx, func(q *database.Queries) error {
// 		var err error

// 		// This should be changed to a generic type
// 		result.Transfer, err = q.CreateTransfer(ctx, database.CreateTransferParams{
// 			FromAccountID: arg.FromAccountID,
// 			ToAccountID:   arg.ToAccountID,
// 			Amount:        arg.Amount,
// 		})

// 		if err != nil {
// 			return err
// 		}

// 		result.FromEntry, err = q.CreateEntry(ctx, database.CreateEntryParams{
// 			AccountID: arg.FromAccountID,
// 			Amount:    -arg.Amount,
// 		})

// 		if err != nil {
// 			return err
// 		}
// 		result.ToEntry, err = q.CreateEntry(ctx, database.CreateEntryParams{
// 			AccountID: arg.ToAccountID,
// 			Amount:    arg.Amount,
// 		})
// 		if err != nil {
// 			return err
// 		}

// 		if arg.FromAccountID < arg.ToAccountID {

// 			result.FromAccount, result.ToAccount, err = repository.addMoney(ctx, q, arg.FromAccountID, -arg.Amount, arg.ToAccountID, arg.Amount)

// 			if err != nil {
// 				return err
// 			}

// 		} else {
// 			result.ToAccount, result.FromAccount, err = repository.addMoney(ctx, q, arg.ToAccountID, arg.Amount, arg.FromAccountID, -arg.Amount)

// 			if err != nil {
// 				return err
// 			}
// 		}
// 		return nil
// 	})

// 	return result, err
// }

// func (repository *Repository) addMoney(ctx context.Context, q *database.Queries, account1ID, account1Amount, account2ID, account2Amount int64) (account1, account2 database.Account, err error) {
// 	account1, err = q.AddAccountBalance(ctx, database.AddAccountBalanceParams{
// 		ID:     account1ID,
// 		Amount: account1Amount,
// 	})

// 	if err != nil {
// 		return
// 	}

// 	account2, err = q.AddAccountBalance(ctx, database.AddAccountBalanceParams{
// 		ID:     account2ID,
// 		Amount: account2Amount,
// 	})

// 	if err != nil {
// 		return
// 	}

// 	return
// }
