# Account-Service-API

A very simplistic REST API made by Java Spring framework with Maven build.

This API works as a simple service for accounts, the service has all the needed CRUD operations and also a transfer operation that allow the accounts to send and receive money among themselves.

The data is stored in MySQL database, you just need to create the schema with the name `AccAPI` or change the properties file to your liking. Also in the propertise file you can uncomment the SQLServer configuration commands and work with SQLServer database.

Here is the HTTP requests you can use with this API:

## HTTP Requests

### Account Requests

#### GET All Accounts

<https://localhost:8080/api/v1/accounts>

#### GET An Account by ID

<https://localhost:8080/api/v1/accounts/{id}>

The {id} integer represents the id of the Account in the database.

#### GET An Account by First Name

<https://localhost:8080/api/v1/accounts/search/fname?q=value>

This requset takes a String parameter `q` and its value represents the first name to search for.

#### GET An Account by Last Name

<https://localhost:8080/api/v1/accounts/search/lname?q=value>

This requset takes a String parameter `q` and its value represents the last name to search for.

#### GET All Accounts with IDs between

<https://localhost:8080/api/v1/accounts/search/idsbetween?f=value1&l=value2>

This request takes two integer parameters `f` and `l`, the request returns all ids between value of parameter `f` and `l`.

#### GET With Pagination

<https://localhost:8080/api/v1/accounts/search/paginate?page=value1&size=value2>

This request takes two integer parameters `page` and `size`, the request paginate the returned values. Both parameters are not required and have a default values. the `page` default value returns the first page, the `size` default value returns two accounts per-page.

#### POST An Account

<https://localhost:8080/api/v1/accounts>

The body of the request should have a JSON object like this :

```JSON
{
    "fname": "first name",
    "lname": "last name",
    "balance": 10000
}
```

#### DELETE An Account by ID

<https://localhost:8080/api/v1/accounts/{id}>

The {id} integer represents the id of the Account in the database.

#### PUT An Account

<https://localhost:8080/api/v1/accounts>

The body of the request should have a JSON object like this :

```JSON
{
    "fname": "new first name",
    "lname": "new last name",
    "balance": 10000
}
```

#### PATCH An Account by ID

<https://localhost:8080/api/v1/accounts/{id}>

The {id} integer represents the id of the Account in the database.

The body of the request should have a JSON object like this :

```JSON
{
    "lname": "new last name"
}
```

In this request you can ignore the parameters you don't intend to alter, the values will remain the same after the request.

### Transfer & Transaction Requests

#### POST A Transfer

<https://localhost:8080/api/v1/transfer>

The body of the request should have a JSON object like this :

```JSON
{
    "sender": 1,
    "receiver": 2,
    "amount": 1000
}
```

The sender and receiver parameters refer to the ids of the accounts that the transaction will be done to.

#### GET All Transactions

<https://localhost:8080/api/v1/transactions>

#### GET A Transaction by ID

<https://localhost:8080/api/v1/transactions/{id}>

The {id} integer represents the id of the Transaction in the database.

### Error Codes

The Requests has the following Error Codes :

#### 1- ResourceNotFound

```JSON
{
    "code": 1,
    "message": "Account with this id not found",
    "details": "make sure to submit a viable id"
}
```

#### 2- InsufficientBalance

```JSON
{
    "code": 2,
    "message": "Insufficient funds for the completion of the transaction",
    "details": "Make sure the required funds are available"
}
```
