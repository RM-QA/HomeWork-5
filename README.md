| No | the check name (MathUtils class)                                                             | Status |
|----|----------------------------------------------------------------------------------------------|--------|
| 1  | when adding two positive integers (the add method In MathUtils class)                        | pass   |
| 2  | when adding a positive integer to zero (the add method In MathUtils class)                   | pass   |
| 3  | when adding a positive integer to zero (the add method In MathUtils class)                   | pass   |
| 4  | when adding a negative integer to a positive integer (the add method In MathUtils class)     | pass   |
| 5  | when adding large integers with result in overflow (the add method In MathUtils class)       | pass   |
| 6  | when the first argument is larger (the bigger method in MathUtils class)                     | pass   |
| 7  | when the second argument is larger (the bigger method in MathUtils class)                    | pass   |
| 8  | when the first and the second argument are equals (the bigger method in MathUtilsTest class) | pass   |
| 9  | when using floating Point Division (the division method in MathUtils class )                 | pass   | 
| 10 | when using floating Point multiply (the multiply method in MathUtils class )                 | pass   |
| 11 | when test Square number (the squre method in MathUtil class)                                 | pass   |
| 12 | when adding two positive floats  (the add method In MathUtils class)                         | pass   |
| 13 | when Multiply tow Floats (the add method In MathUtils class)                                 | pass   |

------------------------------------------------------------------------------------------------------

| No | the check name (Solver class)                                                   | Status |
|----|---------------------------------------------------------------------------------|--------|
| 1  | when the quadratic equations result is less than (0) it should return (0) root  | pass   |
| 2  | when the quadratic equations result is equal (0) it should return (1) root      | pass   |
| 3  | when the quadratic equations result is more than (0) it should return (2) roots | pass   |

------------------------------------------------------------------------------------------------------

| No | the check name (GET/test-orders/{id})    (homework 10)                                                                                                                      | Status |
|----|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| 1  | GET method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller/getById using test data ID "1" EXPECT success result, STATUS response code "200"  | pass   |
| 2  | GET method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller/getById using test data ID "5" EXPECT success result, STATUS response code "200"  | pass   |
| 3  | GET method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller/getById using test data ID "10" EXPECT success result, STATUS response code "200" | pass   |
| 4  | GET method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller/getById using test data ID "12" EXPECT bad request, STATUS response code "400"    | pass   |
| 5  | GET method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller/getById using test data ID "0" EXPECT bad request, STATUS response code "400"     | pass   |

------------------------------------------------------------------------------------------------------

| No | the check name (POST/test-orders)    (homework 10)                                                                                                                                                                                   | Status |
|----|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| 1  | post method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller using valid test data ("customerName","customerPhone") EXPECT success result, STATUS response code "200"                                  | pass   |
| 2  | post method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller using invalid test data ("customerName","customerPhone") EXPECT bad request, STATUS response code "400"                                   | pass   |
| 3  | post method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller  using  missing required data EXPECT bad request, STATUS response code "400"                                                              | pass   |
| 4  | post method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller  using valid data (customerName,customerPhone) without Double quotation, EXPECT Incorrect query, STATUS response code "400"               | pass   |
| 5  | post method for URL: http://51.250.6.164:8080/swagger-ui/index.html#/test-order-controller  using valid data (customerName,customerPhone) and (courierId) more than 15 characters, EXPECT Incorrect query, STATUS response code "400"| pass   |
 
                              
