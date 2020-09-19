
# What the f*uck Java!

Compare java and python with topics covered in [wtfpython](https://github.com/satwikkansal/wtfpython).


# Table of Contents

<!-- Generated using "markdown-toc -i README.md --maxdepth 3"-->

<!-- toc -->

- [What the f*uck Java!](#what-the-fuck-java)
- [Table of Contents](#table-of-contents)
- [👀 Examples](#-examples)
  - [Section: Strain your brain!](#section-strain-your-brain)
    - [▶ First things first! *](#-first-things-first-)
    - [▶ Strings can be tricky sometimes](#-strings-can-be-tricky-sometimes)
  - [#### 💡 Explanation:](#h4-id-explanation-14-explanationh4)
    
<!-- tocstop -->


# 👀 Examples

## Section: Strain your brain!

### ▶ First things first! *


### ▶ Strings can be tricky sometimes

<!-- Example ID: 30f1d3fc-e267-4b30-84ef-4d9e7091ac1a --->
1\. Input:

```java
String a = "some_thing";
System.identityHashCode(a);
System.identityHashCode("some" + "_" + "string");
```
Output:
```
Defined field String a = "some_thing"
System.identityHashCode(a) = 128893786
System.identityHashCode("some" + "_" + "string") = 1108411398
```

2\. Input:
```java
String a = "wtf";
String b = "wtf";
System.out.println(a == b);

String a = "wtf!";
String b = "wtf!";
System.out.println(a == b);
```

Output:
```
field String a = "wtf"
field String b = "wtf"
System.out.println(a == b)
true

field String a = "wtf!"
field String b = "wtf!"
System.out.println(a == b)
true
```

4\.

**Output (java11)**

```java
System.out.println("a".repeat(20) == "aaaaaaaaaaaaaaaaaaaa");
System.out.println("a".repeat(21) == "aaaaaaaaaaaaaaaaaaaaa");
```

Output:
```
System.out.println("a".repeat(20) == "aaaaaaaaaaaaaaaaaaaa")
false

System.out.println("a".repeat(21) == "aaaaaaaaaaaaaaaaaaaaa")
false
```

#### 💡 Explanation:
---