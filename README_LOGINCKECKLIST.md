1- Checklist for functional (EN login) page in “ EN”

Name of product : Tallinn delivery web App
Precondition : the student should create an account in advance
 
| No | Check name for (EN login) page                                                                                                                                                                                                  | Status  | comment |
|----|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|---------|
| 1  | When the user provides the correct “Tallinn delivery” web app link in the browser and clicks enter, the sign in page should be displayed.                                                                                       | passed  |         |
| 2  | When the user provides valid credential data “ login and password” and clicks’ the sign in’ button the ‘create order’ page should be displayed. (Positive scenario)                                                             | passed  |         |
| 3  | when the user provides invalid credential data ‘login and password” and clicks’ sign in’ button the “ incorrect credentials “ message should be displayed (negative scenario)                                                   | passed  |         |
| 4  | when the user provides “empty fields” credential data “ login and password” and click ’ sign in’ button the “ login and password “ fields border should be return to “ red color” and stay in the same page (negative scenario) | passed  |         |
| 5  | when the user provides "empty login field and valid password data” and clicks ’sign in’ button the “ incorrect credentials “ message should be displayed (negative scenario)                                                    | passed  |         |
| 6  | when the user provides "empty password field and valid login data” and clicks ’sign in’ button the “ incorrect credentials “ message should be displayed (negative scenario)                                                    | passed  |         |
| 7  | when the user provides "invalid login data and valid password” and clicks ’sign in’ button the “ incorrect credentials “ message should be displayed (negative scenario)                                                        | passed  |         |
| 8  | when the user provides "valid login data and invalid password” and clicks ’sign in’ button the “ incorrect credentials “ message should be displayed (negative scenario)                                                        | passed  |         |
| 9  | The password is displayed on the frontend encrypted                                                                                                                                                                             | failed  | BR 01   |
| 10 | Login field accepts no more than 30 characters only                                                                                                                                                                             | passed  |         |
| 11 | Login field accepts no less than 2 characters                                                                                                                                                                                   | passed  |         |
| 12 | Password field accepts no less  than 8 characters                                                                                                                                                                               | passed  |         |
| 13 | Password field accepts no more than 30 characters                                                                                                                                                                               | passed  |         |
| 14 | When student change the  language the chosen language button should be display in yellow color  (Positive scenario) (non-functional " layout")                                                                                  | passed  |         |
| 15 | The title on top of the page should be "Tallinn Delivery"  (nonfunctional " layout")                                                                                                                                            | failed  | BR 02   |

---------------------------------------------------------------------------------------------------------
BR 01
-----

The front end displays the actual value of the password and does not encrypt it. (checked on dev tools) 

Playback steps:

Provide valid webApp link in browser

Create account in advanced

Provide name and password

+ Expected result : The front end displays encrypted password

+ Actual result : The front end displays the actual value of the password

Environment : Windows : 11           
firefox : 121.0 (64.bit)

Priority - medium

Severity -medium

BR 02
-----

The title on top the screen is not correct, it says "Tallin Delivery" with one N, but the city name is actually with two Ns "Tallinn Delivery"  

Playback steps : Provide valid webApp link in browser

+ Expected result : the “ title “ on the top of the page should be “ Tallinn delivery”.

+ Actual result : the “title “ on the top of the page is “ Tallin delivery”

Environment : Windows : 11           
firefox : 121.0 (64.bit)

Priority - low

Severity - trivial

----------------------------------------------------------------------------------

2- the list of web elements required for the checks : 

| No | Name of the element        | Xpath selector                               | 
|----|----------------------------|----------------------------------------------|
| 1  | Login data field           | //input[@data-name='username-input']         |
| 2  | Password data field        | //input[@data-name='password-input']         |
| 3  | SignIn button              | //button[@data-name="signIn-button"]         | 
| 4  | Authentication error popup | //div[@data-name="authorizationError-popup"] |
| 5  | (EN) language button       | //button[text()="EN"]                        |
| 6  | (Ru) language button       | //button[text()="RU"]                        |



