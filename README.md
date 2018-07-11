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
	        implementation 'com.github.rishikumars:NewsApi:2.1'
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
CurrentNews.getHeadlinesByCountry(Country.MEXICO);
CurrentNews.getNewsByTopic(String topic);
CurrentNews.getNewsByCategory(Category.TECHNOLOGY);
CurrentNews.getNewsByLanguage(Language.ENGLISH);
```

## Steps to use the library functions

#### 1.Add the repository and the dependencies
#### 2.Get your api key from newsapi.org by signing up
#### 3.Pass your api key as a parameter into initApi() function
 
 Example 
 ```
 CurrentNews.initApi("your api key");
```
#### 4.After initializing your api key call any of the functions

Example
```
CurrentNews.getHeadlinesByCountry(Country.INDIA);
CurrentNews.getNewsByTopic(String topic);
CurrentNews.getNewsByCategory(Category.SPORTS);
CurrentNews.getNewsByLanguage(Language.RUSSIAN);
```

#### 5.The above functions returns list object

Example
```
List<Map> list=CurrentNews.getHeadlinesByCountry(Country.INDIA);
List<Map> list=CurrentNews.getNewsByTopic(String topic);
List<Map> list=CurrentNews.getNewsByCategory(Category.SPORTS);
List<Map> list=CurrentNews.getNewsByLanguage(Language.RUSSIAN);

```
#### 6.Using map ,we can access specific fields...

For example 
```
The function getNewsByCategory() and getNewsByLanguage() returns fields like 

id , name , description , url , category , language , country

List
    [0]--->Map(id,name,description,url,category,language,country)
    [1]--->Map(id,name,description,url,category,language,country)
    [2]--->Map(id,name,description,url,category,language,country)
    [3]--->Map(id,name,description,url,category,language,country)
    [4]--->Map(id,name,description,url,category,language,country)
    .....
```


```
The functions getNewsByTopic() and getHeadLinesByCountry() returns fields like

author , title , description , url , urlToImage , publishedAt 
List
    [0]--->Map(author,title,description,url,urlToImage,publishedAt)
    [1]--->Map(author,title,description,url,urlToImage,publishedAt)
    [2]--->Map(author,title,description,url,urlToImage,publishedAt)
    [3]--->Map(author,title,description,url,urlToImage,publishedAt)
    ......
```
#### 7.To access specific fields

Example 

```
List<Map> list=CurrentNews.getHeadlinesByCountry(Country.NORWAY);
for(Map<String,String> news:list)
  {
  //map.get("field_name");
  map.get("author");
  map.get("title");
  map.get("description");
  map.get("url");
  map.get("urlToImage");
  map.get("publishedAt");
}
```

## Sample code
[Sample code using NewApi library](https://github.com/rishikumars/sampleNews.git)

