
## Authors

- [@criferlo2](https://www.github.com/criferlo2)


# Presentation of project for MercadoLibre Jobs

## Appendix

- Goal
- Result
- Technologies
- Architecture
- UDF applied
- Error managing
- Patterns
- Test Unit
- Layouts design
- Link to the repository



## Features

- **Goal**
The goal of this project is to present a list of products that the user is searching with a keyword, and the user can check the product description.

- **Result**

The user can enter the keyword and the app will search into the API the results that are rendered so:


![Logo](https://github.com/criferlo2/melitest1/blob/main/success-meli.png?raw=true)

Then if the user clicks one card the app redirect to it’s detail such as:

![Logo](https://github.com/criferlo2/melitest1/blob/main/success%20detail%20-meli.png?raw=true)

- **Technologies**

The selected technologies for this project are the following:

    - Jetpack compose
    - Jetpack compose navigation
    - Hilt (dependency injection)
    - Retrofit
    - LiveData
    - JUnit and Mockito
    - Timber for logs

- **Architecture**

The selected architecture is MVVM and the principle is Clean Architecture. This architecture is simple and scalable because the data is passed from the service to the repository, then the repository to the viewmodel and consumed from the user interface by using an observable object in the components that requires it.

In fact this architecture is the suggested by Google that you can check in: https://developer.android.com/topic/architecture 


- **UDF applied**
Unidirectional Data Flow applied in the project by using actions from the UI and observing the state with LiveData that is waiting for the data from the Repository.

- **Error managing**

I wrote an Error Screen and it is waiting for the state of erroLiveData of viewModel, in this element we can pass an error code and a particular message. The message could arrive from the service or it could be defined by​​ the developer. Also I wrote a Timber Log in order to present a message in Console to support the developer.

![Logo](https://github.com/criferlo2/melitest1/blob/main/manageerror-meli.png?raw=true)

- **Patterns**

    - I wrote taking S.O.L.I.D principles, and taking design patterns such as: 
    - Factory (creational pattern) (when I used Hilt, I look for a instantiation of objects from a Factory that are injected into Components or classes as ProductRepository)
    - Singleton (creational pattern), when I use Hilt I look for only one instance of objects.
    - Builder (creational pattern) there are a builder pattern when I used provideRetrofit in order to get the retrofit object, Retrofit.builder()
    - Facade and Composite (structural pattern) when I use jetpack compose to create components I used Facade to hide the implementation of the components, and composite in order to get a hierarchy of components in only one view.
    - Observer (behavior pattern) When I use LiveData and I observe it as state in a compose component we are using observer pattern in order to see the changes and the component react with these changes.

- **Unit testing**

I wrote unit test for: ProductRepository and ProductViewModel, because these classes have the code for getting the data from API and passing it to the User interface. 

![Logo](https://github.com/criferlo2/melitest1/blob/main/unit%20testing%20meli.png?raw=true)

This coverage is important for projects because it shows how many lines are covered for tests. 

- **Layouts design**

As you can see in the code, I wrote Jetpack Compose components in order to utilize the last technologies of Android. This technology helps us to build layouts extremely fast and optimized. I wrote a Content component using LazyVerticalGrid, which accelerate the creation of a grid with a lot of elements.

- **Link to the repository:**

    -  https://github.com/criferlo2/melitest1

I appreciate your time to read this document.

Thanks.


