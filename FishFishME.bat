set projectLocation=D:\@soft\Eclipse_Neon\Workspace\FishFishMe_Template
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\ExternalJars\*
java org.testng.TestNG %projectLocation%\FishFishMe.xml
pause
