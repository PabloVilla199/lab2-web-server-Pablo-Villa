# Lab 2 Web Server -- Project Report

## Description of Changes
The base project was a web server in **Spring Boot with
Kotlin** the project has any routes defined and only showed the
Default error page.
To complete the practice, the first thing I did was create an `error.html` page in the
`src/main/resources/templates` and them customize the error page that
displayed when requesting non-existing routes. To check that everything worked 
i made a unit test (`ErrorPageTest`) that validates that this page
custom is returned successfully.

Next I implemented the `/time` endpoint following the instructions of the
guide, creating the `TimeComponent` class and the `TimeController`. This
endpoint returns the current time in JSON format. I also made a unit
test (`TimeControllerTest`) to verify that the endpoint is responding
with the server time correctly.

Finally, I configured **HTTP/2 and SSL**. In my case,
I chose to generate the self-signed certificate with **WSL instead of
PowerShell**, because it was easier to use OpenSSL from Linux. With the
first command I generated the private key and the certificate, and with the
second I created a PKCS#12 keystore (`localhost.p12`) that contains
both. I moved this file to `src/main/resources` and then set a
`application.yml` to enable SSL and enable HTTP/2 on the port
I added an `application-test.yml` in the tests.
to simplify alla and disabled SSl to run the tests,

## Technical Decisions
Although the practice was very guided, I made some decisions that
They seemed relevant.
.
- First of all I decided to generate a feature branch to work on the implementation of the practice 
  instead of using a main branch, this way I had a more organized and easier to manage workflow.
- Later i decided to use **WSL instead of PowerShell** to work with OpenSSL, 
  which avoided configuration problems and simplified the certificate generation process.
- I also decided to **separate the configuration in `application.yml` and
  `application-test.yml`**, so the server runs with SSL, but tests can run without SSL.

## Learning Outcomes
Thanks to this practice it has allowed me to refresh html since it is a part of my skills
 that I don't manage and I learned to create an **error page
personalized**, something that i never worked before. 
I also understood about generation of
SSL certificates and the configuration necessary to enable HTTPS and
on the server. Additionally, I improved my Git skills by
working with branches instead of on the main branch, a habit that
Although in this lab practice is not critica bu is important when you work in a a big project. 
I have also reinforced doing something like tdd, but when doing a feature, test it before doing all the features and then testing them.


## AI Disclosure
### AI Tools Used
- ChatGPT

### AI-Assisted Work
 I used AI to get a basic skeleton of the template
`error.html` and initial examples of the error and timing tests.
 10% AI, 90% original

### Original Work
This practice was highly guided, so the AI ​​was only useful for specific and basic doubts. 
I did everything else following the practice guide, since it was very specific and it made 
no sense to rely on AI to implement it.
