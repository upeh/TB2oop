JAVAC = javac
JVM = java
JAVADOC = javadoc
MKBIN = mkdir -p bin

FLAGS = -g -d bin/

CP = -cp bin:src/test/lib/*:src/main/java

MAINSRC = src/main/java/
TESTSRC = src/test/java/

TARGET = bin/

.SUFFIXES : .class .java

all: 
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)Driver.java

Animal: 
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)Animal.java

Cage: Animal Cell
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)Cage.java

FileReader: 
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)FileReader.java

Cell: 
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)Cell.java

MatrixCell: Cell
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)MatrixCell.java

View: 
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)View.java

Visitor: 
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)Visitor.java

VirtualZoo: MatrixCell View Visitor Cell Cage
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(MAINSRC)VirtualZoo.java

AnimalTest: Animal
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)AnimalTest.java

CageTest: Cage
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)CageTest.java

CellTest: Cell
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)CellTest.java

VisitorTest: Visitor
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)VisitorTest.java

ViewTest: View
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)ViewTest.java

MatrixCellTest: MatrixCell
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)MatrixCellTest.java

FileReaderTest: FileReader
	$(MKBIN)
	$(JAVAC) $(FLAGS) $(CP) $(TESTSRC)FileReaderTest.java

testAnimal:
	$(JVM) $(CP) org.junit.runner.JUnitCore AnimalTest

testCage:
	$(JVM) $(CP) org.junit.runner.JUnitCore CageTest

testCell:
	$(JVM) $(CP) org.junit.runner.JUnitCore CellTest

testVisitor:
	$(JVM) $(CP) org.junit.runner.JUnitCore VisitorTest

testView:
	$(JVM) $(CP) org.junit.runner.JUnitCore ViewTest

testMatrixCell:
	$(JVM) $(CP) org.junit.runner.JUnitCore MatrixCellTest

testFileReader:
	$(JVM) $(CP) org.junit.runner.JUnitCore FileReaderTest

clean:
	rm -rf $(TARGET)

run:
	$(JVM) $(CP) Driver

.PHONY: all test clean run run_test
