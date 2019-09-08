# Vo(fx)el
**Vofxel** is a Java library for loading, displaying and editing PLY files exported from [MagicaVoxel](https://ephtracy.github.io/) into JavaFX.

## Installation

### Maven
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
<dependency>
	<groupId>com.github.iAmGio</groupId>
	<artifactId>vofxel</artifactId>
	<version>v0.0.1</version>
</dependency>
```

### Gradle
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
dependencies {
	implementation 'com.github.iAmGio:vofxel:v0.0.1'
}
```

## Getting started
Load model from file:
```java
VoxelModel model = new VoxelModel();
root.getChildren().add(model);
model.load(getClass().getResourceAsStream("/file.ply"));
```

Note that the file must be exported using the _cube_ mode from MagicaVoxel (or any other tool that supports this export mode):
![Export](https://i.imgur.com/6jpqJFO.png)
   
Create model from scratch:
```java
VoxelModel model = new VoxelModel();
root.getChildren().add(model);
Cube cube1 = model.addCube();
cube1.setMaterial(new PhongMaterial(Color.RED));
cube1.moveZ(-10);
Cube cube2 = model.addCube();
cube2.setMaterial(new PhongMaterial(Color.BLUE));
cube2.moveX(-10);
```

## Demo
A simple demonstration can be found [here](https://github.com/iAmGio/vofxel/blob/master/src/test/java/eu/iamgio/vofxel/AppTest.java).

![Result](https://i.imgur.com/wwN5Zh2.png) 