# Проект по автоматизации тестирования для компании [Росгосстрах](https://www.rgs.ru/)

## **Содержание:**
____


* <a href="#tools">Технологии и инструменты</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#allure">Allure отчет</a>
* <a href="#allure-testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#telegram">Уведомление в Telegram </a>
* <a href="#video">Видео примера запуска тестов в Selenoid</a>
____

<a id="tools"></a>
## **Технологии и инструменты**

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
<img width="5%" title="Jira" src="media/logo/Jira.svg">
</p>


- Язык программирования для написания автотестов: 
  - <code>Java</code>
- Фреймворки для тестирования:
  - [Selenide](https://selenide.org/) (для автоматизации браузерных тестов)
  - <code>JUnit 5</code> (для структурирования и запуска тестов)
- Сборка и управление зависимостями: <code>Gradle</code>
- Запуск браузеров в [Selenoid](https://aerokube.com/selenoid/) при прогоне тестов
- CI/CD: <code>Jenkins</code> (реализована джоба для удаленного запуска тестов) с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Интеграция с <code>Allure TestOps</code> и <code>Jira</code> (управление тест-кейсами и аналитика)

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

____
<a id="jenkins"></a>
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins.png">
</p>

____
<a id="console"></a>
 ***Запуск из терминала***
```
gradle clean znak_test
```
При выполнении команды, тесты запустятся удаленно в [Selenoid](https://aerokube.com/selenoid/).

***Удаленный запуск через Jenkins***
```
clean
znak_test
-Dbrowser=${browser}
-Dversion=${version}
-DwindowSize=${windowSize}
-Dselenoid.url=https://user1:1234@${selenoid.url}/wd/hub
```
***Параметры сборки в Jenkins***

- *browser (браузер, в котором выполнятся тесты - по умолчанию chrome)*
- *version (версия браузера - по умолчанию 127)*
- *windowSize (размер окна браузера, в котором будут выполняться тесты)*
- *selenoid.url (адрес удаленного сервера, на котором будут запускаться тесты)
____
<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure-отчета

<p align="center">
<img title="Allure Overview" src="media/screens/AllureReport.png">
</p>

В отчете Allure представлены результаты тестирования с общей статистикой.
____
<a id="allure-testops"></a>
## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с Allure TestOps

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
На дашборде представлен состав тест-кейсов (автоматизированные и ручные кейсы), запуски, результаты прогонов (успешные/неуспешные тесты)
<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureTestOps.png">
</p>

____
<a id="jira"></a>
## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>,в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screens/Jira.png">
</p>

____
<a id="telegram"></a>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в Telegram, автоматически обрабатывает и отправляет сообщение с результатом.
<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/Bot.png">
</p>

____
<a id="video"></a>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>