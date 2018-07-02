# NewsApi

It is a Java Library to get the updated news by country,topic,category and language

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

1.Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

 2.Add the dependency

	dependencies {
	        implementation 'com.github.rishikumars:NewsApi:1.0'
	}

### Usage

The functionalities avalable in this library are
  ```
  initApi(String api);
  getHeadlinesByCountry(String country);
  getNewsByTopic(String topic);
  getNewsByCategory(String category);
  getNewsByLanguage(String language);
```
These functions are available in the class "CurrentNews"

```
CurrentNews.initApi(String api);
CurrentNews.getHeadlinesByCountry(String country);
CurrentNews.getNewsByTopic(String topic);
CurrentNews.getNewsByCategory(String category);
CurrentNews.getNewsByLanguage(String language);
```

## Steps to use the library functions

#### 1.Add the repository and the dependencies
#### 2.Get your api key from newsapi.org by signing up
#### 3.Pass your api key as a parameter into initApi() function
 
 Example 
 ```
 CurrentNew.initApi("your api key");
```
#### 4.After initializing your api key call any of the functions

Example
```
CurrentNews.getHeadlinesByCountry(String country);
CurrentNews.getNewsByTopic(String topic);
CurrentNews.getNewsByCategory(String category);
CurrentNews.getNewsByLanguage(String language);
```

#### 5.The above functions returns list object

Example
```
List<Map> list=CurrentNews.getHeadlinesByCountry(String country);
List<Map> list=CurrentNews.getNewsByTopic(String topic);
List<Map> list=CurrentNews.getNewsByCategory(String category);
List<Map> list=CurrentNews.getNewsByLanguage(String language);

```
#### 6.Using map ,we can access specific fields...

For example 
```
The function getNewsByCategory() and getNewsByLanguage() returns fields like 

id , name , description , url , category , language , country
```


```
The functions getNewsByTopic() and getHeadLinesByCountry() returns fields like

author , title , description , url , urlToImage , publishedAt 
```
#### 7.To print specific fields

Example 

```
List<Map> list=CurrentNews.getHeadlinesByCountry(String country);
for(Map<String,String> news:list)
  System.out.println(map.get("field_name"));


