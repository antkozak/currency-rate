package com.newsoft.rate.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


/**
 * Tests Jibx unmarshalling.
 */
public class JibxDailyExchangeRatesTest {

    @Test
    public void marshallToFile() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IBindingFactory bindingFactory = BindingDirectory.getFactory(DailyExchangeRatesImpl.class);
        IMarshallingContext mctx = bindingFactory.createMarshallingContext();

        DailyExchangeRatesImpl rates = new DailyExchangeRatesImpl();
        Date currDate = new Date();
        rates.setRateDate(currDate);
        CurrencyRateImpl rate1 = new CurrencyRateImpl();
        rate1.setId(1L);
        rate1.setName("rate1");
        rate1.setCode("code1");
        rate1.setRate(1000D);
        CurrencyRateImpl rate2 = new CurrencyRateImpl();
        rate2.setId(2L);
        rate2.setName("rate2");
        rate2.setCode("code2");
        rate2.setRate(2000D);
        rates.getRates().add(rate1);
        rates.getRates().add(rate2);
        mctx.marshalDocument(rates, "UTF-8", null, outputStream);

        IUnmarshallingContext unmarshallCtx = bindingFactory.createUnmarshallingContext();
        DailyExchangeRatesImpl data = (DailyExchangeRatesImpl) unmarshallCtx.unmarshalDocument(
            new ByteArrayInputStream(outputStream.toByteArray()), "UTF-8");
        assertNotNull(data);
        assertEquals(data.getRates().size(), 2);
    }


    @Test
    public void testJibxUnmarshall() throws Exception {
        IBindingFactory bindingFactory = BindingDirectory.getFactory(DailyExchangeRatesImpl.class);
        IUnmarshallingContext unmarshallCtx = bindingFactory.createUnmarshallingContext();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(transformPublishMessage("/test_input.xml"));
        DailyExchangeRatesImpl data = (DailyExchangeRatesImpl) unmarshallCtx.unmarshalDocument(inputStream, "UTF-8");
        assertNotNull(data);
    }

    /**
     * Transforms input XML.
     *
     * @param pathToXML path to XML file
     * @return result of xsl transformation
     * @throws Exception, when error occurs
     */
    private byte[] transformPublishMessage(String pathToXML) throws Exception {
        InputStream is1 = null;
        InputStream is2 = null;
        try {
            is1 = getClass().getResourceAsStream("/exchange-rate.xsl");
            is2 = getClass().getResourceAsStream(pathToXML);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(is1));
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            transformer.transform(new StreamSource(is2), new StreamResult(outStream));
            return outStream.toByteArray();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(is1 != null) {
                is1.close();
            }
            if(is2 != null) {
                is2.close();
            }
        }
    }
}
