# JVMailStress

JVMailStress is a smtp stress tool with UI supported, designed to test your email server for stress.<br>
This tool send e-mail by randomly selecting sender, recipient, subject, attachment, and content.<br>


# Features :
  - GUI using (Windows native supported)
  - Works in Background
  - Uses as many workers
  - All outputs are visible in the gui interface
  - Setable connection, write and standart timeouts
  - More than one sender, recipient, subject, content and attachment randomly combination
  - Shows the smtp processing time
  - Garbage collection supported


Supported OS
------------
  - Windows
  - Linux
  - Mac OS X


# Preperation (Step by step) :
 - Download and install netbeans from https://netbeans.org
 - Import project and run menu / "clean and build project"
 - Go to folder [Project Folder]/target
 - JVMailStress-1.0-SNAPSHOT.jar files and dependency folder copy to another location or folder
 - Rename dependency folder name to lib
 - Double click or "java -jar JVMailStress-1.0-SNAPSHOT.jar" 


# Usage (Step by step) :

![ScreenShot](/screenshot.png)

 - Enter the SMTP Server and SMTP port (integer) values
 - Select content folder (Only text and html content supported) and attachment folder (all files supported)
 - Enter the One or Multiple (line by line) Envelope Sender and Recipients (rfc822 only)
 - Set the Thread (multiple worker count) and Process (process count per thread) integer values
 - Set the timeout milisecond value
 - Enter the One or Multiple (line by line) Subject (utf8 only)
 - Click to start button and enjoy..


License
-------

GNU
