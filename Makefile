#CSC3002S OS Assignment 2 part I Makefile
#Elle Mouton
#12/04/2019


JAVAC=/usr/bin/javac
JAVA = java
PATH = BarrierS

.SUFFIXES: .java .class

$(PATH)/%.class:$(PATH)/%.java
	$(JAVAC) $<
	
CLASSES =	BThread.class\
		Barrier.class\
		BarrierTest.class
		
CLASS_FILES = $(CLASSES:%.class=$(PATH)/%.class)

default: $(CLASS_FILES)


clean:
	/bin/rm $(PATH)/*.class

run:
	$(JAVA) $(PATH)/BarrierTest ${ARGS}