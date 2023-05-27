// package api

// import (
// 	"context"
// 	"log"
// 	"testing"

// 	database "github.com/jmpfrazao/backend-services/bank-service/database/sqlc"
// 	"github.com/jmpfrazao/backend-services/bank-service/utils"
// 	"github.com/stretchr/testify/require"
// )

// func CreateRandomAccount(t *testing.T) database.Account {
// 	arg := database.CreateAccountParams{
// 		Owner:    utils.RandomOwnerName(),
// 		Balance:  utils.RandomMoney(),
// 		Currency: utils.RandomCurrency(),
// 	}

// 	account, err := testQueries.CreateAccount(context.Background(), arg)

// 	require.NoError(t, err)
// 	require.NotEmpty(t, account)

// 	require.Equal(t, arg.Balance, account.Balance)
// 	require.Equal(t, arg.Currency, account.Currency)

// 	require.NotZero(t, account.ID)
// 	require.NotZero(t, account.CreatedAt)

// 	return account
// }

// func TestTransferTx(t *testing.T) {

// 	repository := NewRepository(testDB)

// 	account1 := CreateRandomAccount(t)
// 	account2 := CreateRandomAccount(t)

// 	// run n concurrent transfer transactions
// 	n := 5
// 	amount := int64(10)

// 	errs := make(chan error)
// 	results := make(chan TransferTxResult)

// 	for i := 0; i < n; i++ {

// 		go func() {
// 			result, err := repository.TransferTx(context.Background(), TransferTxParams{
// 				FromAccountID: account1.ID,
// 				ToAccountID:   account2.ID,
// 				Amount:        amount,
// 			})

// 			log.Println(err)
// 			errs <- err
// 			results <- result
// 		}()
// 	}

// 	// check results
// 	existed := make(map[int]bool)

// 	for i := 0; i < n; i++ {
// 		err := <-errs
// 		require.NoError(t, err)

// 		result := <-results
// 		require.NotEmpty(t, result)

// 		transfer := result.Transfer
// 		require.NotEmpty(t, transfer)
// 		require.Equal(t, account1.ID, transfer.FromAccountID)
// 		require.Equal(t, account2.ID, transfer.ToAccountID)
// 		require.Equal(t, amount, transfer.Amount)
// 		require.NotZero(t, transfer.ID)
// 		require.NotZero(t, transfer.CreatedAt)

// 		_, err = repository.GetTransfer(context.Background(), transfer.ID)
// 		require.NoError(t, err)

// 		// check entries
// 		fromEntry := result.FromEntry
// 		require.NotEmpty(t, fromEntry)
// 		require.Equal(t, account1.ID, fromEntry.AccountID)
// 		require.Equal(t, -amount, fromEntry.Amount)
// 		require.NotZero(t, account1.ID)
// 		require.NotZero(t, account1.CreatedAt)

// 		_, err = repository.GetEntry(context.Background(), fromEntry.ID)
// 		require.NoError(t, err)

// 		toEntry := result.ToEntry
// 		require.NotEmpty(t, toEntry)
// 		require.Equal(t, account2.ID, toEntry.AccountID)
// 		require.Equal(t, amount, toEntry.Amount)
// 		require.NotZero(t, account2.ID)
// 		require.NotZero(t, account2.CreatedAt)

// 		_, err = repository.GetEntry(context.Background(), toEntry.ID)
// 		require.NoError(t, err)

// 		// check account
// 		fromAccount := result.FromAccount
// 		require.NotEmpty(t, fromAccount)
// 		require.Equal(t, account1.ID, fromAccount.ID)

// 		toAccount := result.ToAccount
// 		require.NotEmpty(t, toAccount)
// 		require.Equal(t, account2.ID, toAccount.ID)

// 		// check the difference
// 		diff1 := account1.Balance - fromAccount.Balance
// 		diff2 := toAccount.Balance - account2.Balance
// 		require.Equal(t, diff1, diff2)
// 		require.True(t, diff1 > 0)
// 		require.True(t, diff1%amount == 0)

// 		k := int(diff1 / amount)
// 		require.True(t, k >= 1 && k <= n)
// 		require.NotContains(t, existed, k)
// 		existed[k] = true
// 	}

// 	updatedAccount1, err := testQueries.GetAccount(context.Background(), account1.ID)
// 	require.NoError(t, err)

// 	updatedAccount2, err := testQueries.GetAccount(context.Background(), account2.ID)
// 	require.NoError(t, err)

// 	require.Equal(t, account1.Balance-int64(n)*amount, updatedAccount1.Balance)
// 	require.Equal(t, account2.Balance+int64(n)*amount, updatedAccount2.Balance)
// }

// func TestTransferDeadlock(t *testing.T) {
// 	repository := NewRepository(testDB)

// 	account1 := CreateRandomAccount(t)
// 	account2 := CreateRandomAccount(t)

// 	// run n concurrent transfer transactions
// 	n := 10
// 	amount := int64(10)

// 	errs := make(chan error)

// 	for i := 0; i < n; i++ {
// 		fromAccountId := account1.ID
// 		toAccountId := account2.ID

// 		if i%2 == 1 {
// 			fromAccountId = account2.ID
// 			toAccountId = account1.ID
// 		}

// 		go func() {
// 			_, err := repository.TransferTx(context.Background(), TransferTxParams{
// 				FromAccountID: fromAccountId,
// 				ToAccountID:   toAccountId,
// 				Amount:        amount,
// 			})

// 			errs <- err

// 		}()
// 	}

// 	for i := 0; i < n; i++ {
// 		err := <-errs
// 		require.NoError(t, err)

// 	}

// 	updatedAccount1, err := testQueries.GetAccount(context.Background(), account1.ID)
// 	require.NoError(t, err)

// 	updatedAccount2, err := testQueries.GetAccount(context.Background(), account2.ID)
// 	require.NoError(t, err)

// 	require.Equal(t, account1.Balance, updatedAccount1.Balance)
// 	require.Equal(t, account2.Balance, updatedAccount2.Balance)
// }
