# sparklyGiiLD
GiiLD repository for spark functions.

### Overview

This is a collection of functions for Spark that make it easy to use from Spark shell. 

### StripHtml

After you've read your data, use map to strip out HTML and punctuation marks.

val santized = contents.map(x => new StripHtml().call(x.getString(0))

In this example, contents would be the dataframe with 1 or more rows of text data that has HTML tags.

### GiiLD website
[GiiLD.com](http://www.giild.com)
[GiiLD.net](http://www.giild.net)
