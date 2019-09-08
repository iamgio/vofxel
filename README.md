# Vo(fx)el

**Vofxel** is a work-in-progress Java library for loading, displaying and editing PLY files exported from [MagicaVoxel](https://ephtracy.github.io/) into JavaFX.

## Usage
Load model from file:
```java
VoxelModel model = new VoxelModel();
root.getChildren().add(model);
model.load(getClass().getResourceAsStream("/castle.ply"));
```
   
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

## Demo
A simple demonstration can be found [here](https://github.com/iAmGio/vofxel/blob/master/src/test/java/eu/iamgio/vofxel/AppTest.java).

![https://i.imgur.com/wwN5Zh2.png](https://i.imgur.com/wwN5Zh2.png) 