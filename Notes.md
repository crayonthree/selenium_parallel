Surefire Plugin:
 - Used as a maven plugin, dependency.
 - When I run mvn test, surefire is triggered.
 - Scans for test cases, invokes test runner, then
    features, scenarios, step definitions.
 - Surefire helps run test cases parallely on threads.

Initial approach:
 - Running one thread per scenario using surefire.
    Scenarios are test cases inside features.
    <parallel>methods</parallel> runs scenarios parallely as With cucumber, each test scenario is treated as a test method.
 - Running one thread per feature using surefire.
    For features, created a separate runner file for each feature and then used
    <parallel>classes</parallel> runs features parallely as each cucumber test runner class can be run parallely.

New approach:
 - For the multi browser system I tried to maintain this thread arrangement and tried to have one thread per browser running all the feature and the realted test cases on that browser.

New Workflow now:
 - Instead of mvn test, I use the ThreadedBrowserLauncher instead to launch one thread per browser. From my understanding maven with surefire can only run one instance at a time. When we use mvn test, that is when surefire plugin comes into action. Running this "launcher" skips that and instead runs threads on the browser.
 - System.setProperty("browser","default") sets the browser name in each context. Once the browser name in each context is set, the thread runs similar to build 1 of the project (wihtout threads or surefire plugin simply running all features one scenario at a time.)
 - DriverUtilities is same, it gets the browser driver and then runs the features and the test methods using that driver.
 - BrowserContext holds current browser name in thread-safe manner.
 - ThreadLocal is a java class to provide thread local variables. This means data can be stored separately per thread. So when set and get are used, only value related to thread calling that set and get is affected.
 - In ThreadedBrowserLauncher an initial list of browsers is created and then we loop over this list creating a thread for each browser. WE use BrowserContext to store the current browser. Then run the TestRunner.class per thread and print failures. Output and clear the thread storage. Parallel execution of all threads.
 - ConfigReader to read through config.properties and return list of browsers. Currently hardcoded.