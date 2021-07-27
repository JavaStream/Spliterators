# ✂️ Spliterators
Spliterators allows us to use chain of splits.

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


---

Библиотека позволяет производить цепочку последовательных split() операций в функциональном стиле. 
После каждого split() можно выбрать нужный элемент.

Использование библиотеки позволяет избавиться от лишних промежуточных переменных.


## Пример использования Spliterators:
```java
String givenString = "Natural Wonders,Wonders of the World,Mount Everest,Saturn,2,UNESCO";

Spliterators spliterator = new Spliterators(givenString);

String result = spliterator
            .split(",")
                .choice(1)
            .split(" ")
                .choice(0)
            .trim()
            .build();
```

## Старый подход без использования Spliterators:
```java
String givenString = "Natural Wonders,Wonders of the World,Mount Everest,Saturn,2,UNESCO";
        String[] arr = givenString.split(",");
        String[] arr2 = arr[1].split(" ");
        String result = arr2[0];
        System.out.println(result);
```



## Установка

Импортируйте библиотеку в свой проект, используя [jitpack](https://jitpack.io/#JavaStream/spliterators/1.0.0.J1) repository

#### Gradle

1. Добавьте репозиторий jitpack в ваш build.gradle

```gradle
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

2. Добавьте зависимость на библиотеку Spliterators

```gradle
implementation 'com.github.JavaStream:spliterators:1.0.0.J1'
```

Если требуется, то в JitPack можно получить также Maven зависимость.




## License

Apache License 2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

