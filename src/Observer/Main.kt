package Observer

fun main(){
    val sub1 : Subscriber = Subscriber()
    val sub2 : Subscriber = Subscriber()

    val programmingBlog : Blog = Blog()
    val flowerBlog : Blog = Blog()

    programmingBlog.addObserver(sub1)
    programmingBlog.addObserver(sub2)
    programmingBlog.article = "Java tutorial"
    programmingBlog.notifyObservers(programmingBlog.article)

    flowerBlog.article = "New flower"
    flowerBlog.addObserver(sub2)
    flowerBlog.notifyObservers(flowerBlog.article)





}