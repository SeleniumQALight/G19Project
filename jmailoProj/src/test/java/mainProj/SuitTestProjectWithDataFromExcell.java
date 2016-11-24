package mainProj;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestValidEntrance.class,
                TestAddApparat.class,
                TestAddWorker.class,
                TestAddSparePart.class,
                TestAddServiceJob.class
        }
)
public class SuitTestProjectWithDataFromExcell {


}
