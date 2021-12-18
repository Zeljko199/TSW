package testovi;


import java.util.logging.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;


class TestRunner {

	public static void main(String[] args) {
		
		org.junit.runner.Result result = JUnitCore.runClasses(RadnikTests.class, ZaposleniTests.class);

        Logger l = Logger.getLogger(TestRunner.class.toString());

        for(Failure f : result.getFailures()){
            l.warning(f.toString());
        }

        l.info("Vreme izvrsavanja: " + result.getRunTime());
        l.info("Ukupan broj izvrsavanja: " + result.getRunCount());

        l.info("Broj uspesno izvrsenih testova: " + (result.getRunCount() - result.getFailureCount() - result.getIgnoreCount() ));
        l.info("Broj palih testova: " + result.getFailureCount());
        l.info("Broj preskocenih testova: " + result.getIgnoreCount());
        l.info("Broj dinamicki preskocenih testova: " + result.getAssumptionFailureCount());

        if(result.wasSuccessful()){
            l.info("Svi testovi su uspesno izvrseni");
        } else {
            l.info("Postoje greske u testovina");
	}
}
	
}
