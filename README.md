# Java Book Library For Internship

*Visma’s book library using Java Spring Boot*

To display all books in the library
```
/show
```
To add new book to library
```
/add?{name}&{author}&{category}&{language}&{publicationDate}&{isbn}&{guid}
```
To find book by GUID
```
/search/{guid}
```
To take a book from library (period in months)
```
/takeBook/{name}/{guid}/{period}
```
To filter books use
```
filter/{section}/{parameter}
section can be one of items(name, author, category, language, isbn, taken, available)
if selected section is taken or available, parameter must be 'null'
```
To remove book from library
```
/remove/{guid}
```
