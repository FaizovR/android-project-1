# android-project-1
Задания выполненные по курсу "Быстрый старт в разработке Android-приложений"

## Упражнение №1

###Задание 1.

Создать проект с пустой активити.
В разметку добавить EditText и Button.
Вводим текст и по нажатию на Button отображаем Toast с введенным текстом. Если в EditText нет текста, то по нажатию на Button ничего не происходит.

###Задание 2.

Создать второй экран с TextView и Button
Второй экран теперь открывается при нажатии на кнопку на первом экране, если в EditText есть текст. (Тост все так же отображается).
В TextView передаем текст из EditText первого экрана.

###Задание 3.

Добавить любой градиент в качестве фона обоим экранам.
По нажатию на Button второго экрана открывается браузер со страницей google.com с вбитым в поиск словом, которое отображается в TextView.

## Упражнение №2

###Задание 1.

Создать проект.
Добавить в активити меню с 3 пунктами - Настройки, Поиск, Выход.
Добавить в разметку активити FrameLayout, который занимает весь экран.
При нажатии на пункты меню появляется тост с названием нажатого пункта.

###Задание 2.

Создать 3 фрагмента.
Эти фрагменты будут меняться в контейнере на экране при нажатии на соответствующие пункты меню. Так же они должны быть добавлены в backstack FragmentManager'а.
Главный - открывается по умолчанию при запуске приложения. (добавляется в контейнер). Добавить разметку на ваше усмотрение.
Настройки - открывается по нажатию на пункт меню Настройки. На разметке находятся RadioButton'ы - три пункта - Google, Яндекс, Bing. Сохранять выбранный пункт в SharedPreferences. Извлекать из SharedPreferences при запуске экрана.
Поиск - открывается по нажатию на пункт Поиск. На разметке находится EditText и Кнопка поиск. При нажатии на кнопку - открывается браузер с поиском введенного текста в выбранном на экране настроек поисковике.
При нажатии на пункт Выход - приложение закрывается.
