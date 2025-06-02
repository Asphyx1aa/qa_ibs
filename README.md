# Проект по автоматизации тестирования для компании [IBS Group](https://ibs.ru/)
____

> IBS — одна из крупнейших российских IT-компаний. Направления деятельности — консалтинг, внедрение бизнес-приложений, IT-аутсорсинг и разработка ПО.

## Содержание:
___

- <a href="#tools">Технологии и инструменты</a>
- <a href="#cases">Примеры автоматизированных тест-кейсов</a>
- <a href="#jenkins">Сборка в Jenkins</a>
- - <a href="#jenkins-params">Параметры сборки в Jenkins</a> 
- - <a href="#commands">Команды для запуска из терминала</a> 
- <a href="#allure">Allure Report</a>
- - <a href="#allure-report">Основная страница отчета</a>
- - <a href="#allure-cases">Тест-кейсы</a>
- <a href="#testops">Интеграция с Allure TestOps</a>
- <a href="#jira">Интеграция с JIRA</a>
- <a href="#telegram">Уведомления в телеграм при помощи бота</a>
- <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
___

<a id="tools"></a>
## Технологии и инструменты:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="media/intellij-original.svg" width="50" height="50" /></a>
<a href="https://www.java.com/"><img src="media/java-original.svg" width="50" height="50" /></a>
<a href="https://junit.org/junit5/"><img src="media/junit-original-wordmark.svg" width="50" height="50" /></a>
<a href="https://selenide.org/"><img src="media/Selenide.svg" width="50" height="50" /></a>
<a href="https://github.com/"><img src="media/github-original.svg" width="50" height="50" /></a>
<a href="https://gradle.org/"><img src="media/gradle-original.svg" width="50" height="50" /></a>
<a href="https://www.jenkins.io/"><img src="media/jenkins-original.svg" width="50" height="50" /></a>
<a href="https://allurereport.org/"><img src="media/Allure.svg" width="50" height="50" /></a>
<a href="https://qameta.io/"><img src="media/qameta.svg" width="50" height="50" /></a>
<a href="https://www.atlassian.com/software/jira"><img src="media/Jira.svg" width="50" height="50" /></a>
</p>

<a id="cases"></a>
## Примеры автоматизированных тест-кейсов:
- Проверка работы фильтра на странице рейтинга
- Проверка корректной работы поиска в шапке сайта
- Проверка корректного переключения языка
- Переход на страницу Контакты и проверка адреса
- Проверка на наличие всех разделов в меню сайта

<a id="jenkins"></a>
## <img src="media/jenkins-original.svg" width="20" height="20" /> Сборка в [Jenkinks](https://jenkins.autotests.cloud/job/033_undef1ned_0_diploma23_ui)
<img src="media/jenkins.jpg"/>

<a id="jenkins-params"></a>
### Параметры сборки в Jenkins
- *WDHOST* (адрес удаленного сервера Selenoid)
- *BROWSER* (браузер, по умолчанию chrome)
- *BROWSER_VERSION* (версия браузера, по умолчанию 128.0)
- *BROWSER_SIZE* (размер окна браузера, по умолчанию 1920x1080)
- *LOGIN_USERNAME* (логин для удаленного сервера)
- *USER_PW* (пароль для удаленного сервера)

<a id="commands"></a>
### Команды для запуска из терминала

Локальный запуск:
```bash
gradle clean test -Denv=local
```

Удалённый запуск через Jenkins:
```bash
gradle clean test
"-Dwdhost=${WDHOST}"
"-Dbrowser=${BROWSER}"
"-Dbrowser_version=${BROWSER_VERSION}"
"-Dbrowser_size=${BROWSER_SIZE}"
"-Dpassword=${USER_PW}"
"-Dlogin=${LOGIN_USERNAME}"
```

<a id="allure"></a>
## <img src="media/Allure.svg" width="20" height="20" /> [Allure Report](https://jenkins.autotests.cloud/job/033_undef1ned_0_diploma23_ui/13/allure)
___
> Allure Report - Фреймворк для формирования удобных и наглядных отчетов о результатах автотестов. Помогает быстро увидеть, какие тесты упали и почему.

<a id="allure-report"></a>
### Основная страница отчета

<img src="media/allure-overview.jpg"/>

<a id="allure-cases"></a>
### Тест-кейсы
<img src="media/allure-report.jpg"/>

<a id="testops"></a>
## <img src="media/qameta.svg" width="20" height="20" /> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4711)
___
> Allure TestOps - платформа для управления автотестами: запуск, аналитика, отслеживание стабильности, ручные тест-кейсы и интеграция с Jira.


<img src="media/allure-testops.jpg"/>

<a id="jira"></a>
## <img src="media/Jira.svg" width="20" height="20" /> Интеграция с [JIRA](https://jira.autotests.cloud/browse/HOMEWORK-1439)
___
> Jira – система трекинга задач и багов. Используется для управления проектом, привязки тест-кейсов и отображения статуса выполнения тестов через интеграцию с TestOps.
> 
<img src="media/jira.jpg"/>

<a id="telegram"></a>
## <img src="media/Telegram.svg" width="20" height="20" /> Уведомления в телеграм при помощи бота:
___
<img src="media/telegram-notify.jpg"/>


<a id="video"></a>
## <img src="media/Selenoid.svg" width="20" height="20" /> Примеры видео выполнения тестов на Selenoid:
___
> Selenoid - инструмент для запуска браузеров в Docker-контейнерах. Позволяет параллельно и стабильно выполнять UI-тесты в разных браузерах.

<img src="media/videotest.gif"/>