# ProjectApp-VolleyRecyclerView

[MainActivity](https://i.imgur.com/2hsalhS.png)
[GalleryActivity](https://i.imgur.com/kH5M7SF.png)

This app consumes a public API called [Pixabay](https://pixabay.com/api/docs/#api_search_images) 
Other libraries used in this project are:

[Volley](https://developer.android.com/training/volley) -> to consume the API
[CardView](https://developer.android.com/topic/libraries/support-library/packages#v7-cardview) -> to display the single entries of the RecyclerView as cards.
[Picasso](https://square.github.io/picasso/) -> To easily download the images

The app attempts to use a MVP pattern to build the RecyclerView logic, handle the Java classes, and the parsing of JSON from the Piabay API.

All the classes and interfaces are as isolated as possible to ensure interchangeability and independency.
There is even a separated interface to handle clicks on the cards.

The click opens up a new Activity that displays the image and the data from the single entrie in the RecyclerView.

