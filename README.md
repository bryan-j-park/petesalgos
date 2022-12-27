

<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

[![LinkedIn][linkedin-shield]][linkedin-url]
[![stars][stars-shield]][stars-url]
[![issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/NeverGiveUp23/HealthFull-project-">
    <img src="food_app/static/img/grocery.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">HealthFull</h3>

  <p align="center">
    Food and Calorie Tracker
    <br />
    <a href="https://github.com/NeverGiveUp23/HealthFull-project-"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/NeverGiveUp23/HealthFull-project-/issues">Report Bug</a>
    ·
    <a href="https://github.com/NeverGiveUp23/HealthFull-project-/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

# petesalgos
Welcome to Pete's Algo's, a Java-based coding practice platform for developers. 
This program uses MySQL, Maven, and Spring Tool Suite to provide a robust and functional back-end, as well as a user-friendly front-end. With Pete's Algo's, 
you can login or register an account to add your own solutions to algorithm questions and save your favorite problems for future practice. The developers 
of Pete's Algo's have also added their own solutions for you to learn from and use as a reference. Whether you're a beginner or an experienced coder, 
Pete's Algo's is the perfect tool to hone your skills and stay sharp. Give it a try today!


<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* ![Next][Next.js]
* ![React][React.js]
* ![Vue][Vue.js]
* ![Laravel][Laravel.com]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]
* ![JQuery][JQuery.com]
* ![MySQL.com][MySQL.com]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.


### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://www.edamam.com](https://www.edamam.com)
2. Clone the repo
   ```sh
   git clone https://github.com/your_username_/HealthFull-project-.git
   ```
3. Install packages
   ```sh
   pipenv install flask pymysql flask-bycript
   ```
4. Enter your API in `script.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Once logged in a user can search any food along with the serving amount that they've eaten throughout the day and save it. A list of calories, protien, and carbs will display.

A user can only save food if they create an account, the date calender will not appear if the user is not logged in.

[![Product Name Screen Shot][product-screenshot2]](https://example.com)


Once the user has saved the meal per specific date, they will be redirected to their dashboard which will display all of their meals with each catogory totaled. I used Chart.js to display visually appealing data for the user. 

The graph on the right is displaying data of saved food totaled up by specific month, the user can use this information to compare their calories month to month.

The Doughnut Chart on the left is to display the information that is in the table but in a more user friendly way. The user can toggle a catogory in the chart and view it specifically. 


[![Product Name Screen Shot][product-screenshot3]](https://example.com)


As the user clicks on "View Meals By Date" on the dashboard page, they will come here a view their meals totaled by the date. I added this page to organize the data for the user. A delete button was made for the user if they felt like there was a mistake with some meals on that specific date.

The next page was very fun for me to make.


[![Product Name Screen Shot][product-screenshot4]](https://example.com)


I decided to add a feature where a user can input goals for the day to keep them on track. I first had issues accessing the page if a user did not have a goal input, I had to involve a bit of logic to allow the user access. 

Now if the use doesn't have any goal input, they will be able to see and emput chart and the three categories at 0. A button will display that says "Create A Goal".

*I added little notes for the user, which i will so make for the user to unput their own notes.*

Also, a table will show of all the meals per that day, along with a delete button.


[![Product Name Screen Shot][product-screenshot5]](https://example.com)


Once the user has inputted their goal for the day, the page will display their goal, current calorie count, and remaining calories. This will adjust as the user inputs more meals per that date as well as deleting data. I also put in a chart for a more visual appeal.


[![Product Name Screen Shot][product-screenshot6]](https://example.com)


_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Via Email - felixvjr0@gmail.com

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]:https://github.com/NeverGiveUp23/HealthFull-project-/network/members
[stars-shield]: https://img.shields.io/github/stars/NeverGiveUp23/HealthFull-project-.svg
[stars-url]: https://github.com/NeverGiveUp23/HealthFull-project-/stargazers
[issues-shield]: https://img.shields.io/github/issues/NeverGiveUp23/HealthFull-project-.svg
[issues-url]: https://github.com/NeverGiveUp23/HealthFull-project-issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/felixvargasjr/
[product-screenshot]: food_app/static/img/Mainpage.png
[product-screenshot2]: food_app/static/img/Mainpageaddingfood.png
[product-screenshot3]: food_app/static/img/mainDashboard.png
[product-screenshot4]: food_app/static/img/Dailytotals.png
[product-screenshot5]: food_app/static/img/Beforegoalinputpage.png
[product-screenshot6]: food_app/static/img/GoalResultPage.png
[Next.js]: https://img.shields.io/badge/Flask-000000?style=for-the-badge&logo=flask&logoColor=white
[React.js]: https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white
[Vue.js]: https://img.shields.io/badge/Python-14354C?style=for-the-badge&logo=python&logoColor=white
[Laravel.com]:https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black
[mySQL.com]: https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
