## 个人博客后端开发文档

### 1、控制层

#### 1.1 响应类

响应的Bean是Response类，转化成json返回前端

```java
class Response<T>{
    // 状态码
	private int status;
    // 返回的实体类，如果没有则返回null
	privete T value;
	
	// constructors
	// setter and getters
}
```

#### 1.2 Entity

对于null的属性，转成json时要将其过滤掉

`@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)`

- Article

  ```java
  class Article{
  	private long id;
  	private String title;
  	private Date date;
  	private long tagId;
  	private String abstracts;
  	// private Category category;
      private String content;
      
      // getters and setters
  }
  ```

- Tag

  ```java
  class Tag{
  	private long id;
      private String name;
  	private int articleNum;
  	private List<Article> articles;
  	
  	// getters and setters
  }
  ```

#### 1.3 控制器

控制器负责将Service层返回的entity包装成Response，并添加必要的状态信息

- ArticleController
  - `Response<List<Article>> getRecentArticles(int pageNum, int pageSize)`	根据指定的页数和页大小返回最近的文章列表
  - `Response<Article> getArticleDetail(long articleId)`    根据文章id返回文章内容
  - `Response<List<Article>> getArchives()`    根据年份返回所有文章的归档列表
- TagController
  - `Response<Tag> getTagName(long tagId)`    根据标签的id返回标签的名称
  - `Response<List<Article>> getArchives(long tagId)`    根据标签id返回该标签下的文章归档列表
  - `Response<List<Tag>> getAllTags() `   返回所有的标签列表
- SearchController
  - `Response<List<Article>> getSearchResult(String key)`    根据搜索关键字返回符合搜索条件的文章列表

### 2、Service层

这一层的接口与实现分离

- ArticleService
  - `List<Article> getRecentArticles(int pageNum, int pageSize)` 	根据指定的页数和页大小返回最近的文章列表，如果没有则返回null
  - `Article getArticleDetail(long articleId)`    根据标签的id返回标签的名称，如果没有则返回null
  - `List<Article> getArchives() `   根据年份返回所有文章的归档列表，没有则返回null
- TagService
  - `Tag getTagName(long tagId)`	根据标签的id返回标签的名称，如果没有则返回null
  - `List<Article> getArchives(long tagId)`    根据标签id返回该标签下的文章归档列表，如果没有则返回null
  - `List<Tag> getAllTags() `   返回所有的标签列表，如果没有则返回null
- SearchService
  - `List<Article> getSearchResult(String key)`    根据搜索关键字返回符合搜索条件的文章列表，如果没有则返回null

### 3、数据访问层

#### 3.1 POJO

- Archive

  ```java
  class Archive{
  	private long id;
  	private Date date;
  	private String title;
  	
  	// setters and getters
  }
  ```

- Article

  ```java
  class Article{
  	private long id;
  	private String title;
  	private Date date;
  	private long tagId;
  	private String abstracts;
      
      // getters and setters
  }
  ```

- Tag

  ```java
  class Tag{
  	private long id;
  	private int articleNum;
      
      // getters and setters
  }
  ```

- SearchResult

  ```java
  class SearchResult{
  	private long id;
  	private String title;
  	private String abstracts;
  	
  	// getters and setters
  }
  ```

#### 3.2 Repository

以下都是接口，除了ArticleContentRepository（使用jpa）外，其他的使用mybatis的xml实现

- ArticleRepository
  - `List<Article> getArticles()`    使用PageHelper插件查询指定页数和页大小的文章列表
  - `List<Archive> getDateAndTitle()`    查找所有文章的日期和标题列表
  - `List<SearchResult> findArticles(String key)`    根据关键字查找标题和摘要中包含该关键字的文章列表
- ArticleContentRepository（为了方便，mongodb的数据访问接口单独抽出来）
  - `String getArticleContent(long articleId)`    根据文章id查询文章内容
- TagRepository
  - `String getName(long tagId)`    根据标签id查询该标签的名称
  - `String getArticles(long tagId)`    根据标签id查找该标签下的文章id列表，格式参考4.t_tags说明
  - `List<Tag> getTags()`    查询所有的标签列表（包括id、名称和文章数）

### 4、数据库

使用mongodb存储文章数据（原生的md文件），其他数据使用mysql存储；其中mongodb中的键值对使用这样的格式：<mysql中的文章id, md文档>

- t_article数据表

  ```mysql
  create table t_article(
      id int(12) not null primary key auto_increment,
      title varchar(255) not null,
      date date not null,
      tag_id int(12) not null,
      abstract varchar(255) not null,
  );
  ```

- t_tag数据表

  ```mysql
  create table t_tag(
      id int(12) not null primary key auto_increment,
      name varchar(32) not null,
      article_num int(12) not null,
      articles varchar(255) not null,
  );
  ```

  ps: articles字段存储对应的文章id，格式化存储格式是："articleId1;articleId2;...;articleIdN"

- mongodb中的表raw_articles：

  ```mongodb
  key: articleId
  value: article_content
  ```

  