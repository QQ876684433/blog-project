## 个人博客前端开发文档

### 1、页面

- 最新文章列表
- 文章详情
- 按标签归档
- 按日期归档
- 标签列表
- 搜索页面

### 2、数据要求

- 最新文章列表
  - 文章id
  - 标题
  - 日期
  - 标签
    - 标签id
    - 标签名称
  - 摘要
- 文章详情
  - 文章id
  - 标题
  - 日期
  - 标签
    - 标签id
    - 标签名称
  - 目录
  - 文章内容
- 按标签归档
  - 标签id
  - 标签名
  - 文章列表
    - 文章id
    - 文章标题
- 按日期归档
  - 文章列表
    - 文章id
    - 日期
      - 年份
      - 日期
    - 文章标题
- 标签列表
  - 标签列表
    - 标签id
    - 标签名称
    - 所属标签文章数
- 搜索页面（目前先按照 **标题** 和 **摘要** 进行搜索，***后期再考虑使用PageRank算法***）
  - 搜索关键词（不需要存到服务器，只是前端组件的state）
  - 文章结果列表
    - 文章id
    - 文章标题
    - 文章摘要



### 3、前端组件化



- Header：顶栏
  - Title：博客名称/logo
  - Navigation：全局导航栏/菜单栏
    - NaviItem：导航项
- Footer：底栏
- Home：首页
  - ref->Header
  - **ref-> ...**：各个导航项对应的组件 
  - ref->Footer
- RecentArticles：最近文章列表
  - ArticleList：文章列表
    - ArticleListItem：文章列表项
      - Title：文章标题
      - PublishDate：发表时间
      - Tag：标签
      - Abstract：摘要
      - Detail：阅读全文
  - PageList：页数跳转
    - ToFirstPage：跳转到第一页
    - ToPreviousPage：上一页
    - ToNextPage：下一页
    - ToLastPage：跳转到最后一页
    - ToSelectedPage：跳转到特定页
- ArticleDetail：文章详情页
  - Title：文章标题
  - Category：文章目录
  - PublishDate：发表日期
  - Tag：标签
  - Content：文章内容
- ArchivesInDate：按日期归档
  - YearlyArchivesList：某年的文章归档
    - YearlyArchivesListItem：某年的文章归档项
- ArchivesInTag：按标签归档
  - ArticleList：文章列表
    - ArticleListItem：文章列表项
- TagList：标签列表
  - TagListItem：标签列表项
- Search：搜索文章页面
  - SearchBar：搜索框
  - ResultArticleList：搜索结果列表
    - ResultArticleListItem：搜索结果列表项
      - Title：标题
      - Abstract：摘要

### 4、前端路由



### 5、数据流模型

- articles: array
  - id
  - article
    - title
    - date
    - tag_id
    - abstract
    - category
    - content
- archives: array
  - id
  - article
    - title
    - date
      - year
      - month_and_day
- tags: array
  - id
  - tag
    - name
    - article_num
    - articles
      - id
      - title
- search_results: array
  - id
  - article
    - title
    - abstract

### 6、接口要求

- /article
  - GET	/recent	page_num: int, page_size: int
  
  ```json
    'values': {
        {
        	'id': 1,
        	'title': xxx,
        	'date': yyyy-mm-dd,
        	'tagId': 1,
        	'abstract': xxx,
    	},
    	{
            'id': 2,
        	'title': xxx,
        	'date': yyyy-mm-dd,
        	'tagId': 1,
        	'abstract': xxx,
        },
    	...
    }
    ```
  
  - GET    /detail    article_id: int
  
    ```json
    'values': {
        'id': 1,
        'category': {
        	// 暂不实现
        },
        'content': xxx,
    }
    ```
  
  - GET    /archives    
  
    ```json
    'values':{
    	{
    		'year': yyyy,
    		'articles': {
    			{
    				'articleId': 1,
    				'date': mm-dd,
    				'title': xxx,
    			},
    			{
    				'articleId': 2,
    				'date': mm-dd,
    				'title': xxx,
    			},
    		},
    	},
    	{
    		'year': yyyy,
    		'articles': {
    			{
    				'articleId': 3,
    				'date': mm-dd,
    				'title': xxx,
    			},
    			{
    				'articleId': 4,
    				'date': mm-dd,
    				'title': xxx,
    			},
    		},
    	},
    	...
    }
    ```
  
    
  
- /tag

  - GET    /name    tag_id: int

    ```json
    'values': {
        'id': 1,
        'name': xxx,
    }
    ```

  - GET    /archives    tag_id: int

    ```json
    'values': {
        'id': 1,
        'articles': {
        	'articleId': 1,
        	'title': xxx,	
        },
    }
    ```

  - GET    /all    

    ```json
    'values': {
    	{
    		'id': 1,
    		'name': xxx,
    		'articleNum': 10,
    	},
    	{
    		'id': 2,
    		'name': xxx,
    		'articleNum': 20,
    	},
    	...
    }
    ```

- /search
  
  - GET	/	key: string
  
    ```json
    'values': {
    	{
        	'articleId': 1,
        	'title': xxx,
        	'abstract': xxx,
    	},
    	{
        	'articleId': 2,
        	'title': xxx,
        	'abstract': xxx,
    	},
    }
    ```
  
    



