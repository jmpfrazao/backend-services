package errors

import "database/sql"

func IsEmptyQueryResult(err error) bool {
	return err == sql.ErrNoRows
}
