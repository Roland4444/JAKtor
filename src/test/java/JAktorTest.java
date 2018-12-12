import Message.MessageSMEV;
import impl.JAktor;
import impl.echoJAKtor;
import io.javalin.Javalin;
import org.junit.Test;


import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class JAktorTest {

    @Test
    public void received_$eq() throws InterruptedException, IOException {
        JAktor la1=new JAktor();
        JAktor la2=new JAktor();
        la1.setAddress("http://127.0.0.1:5555/");
        la2.setAddress("http://127.0.0.1:7777/");
        la1.spawn();
        la2.spawn();
        Thread.sleep(1000);
        la1.send("hi".getBytes(),  la2.Address);
        Thread.sleep(500);
        assertEquals(new String("hi".getBytes()), new String(la2.received.getBytes()) );
        long startTime = System.currentTimeMillis();
        byte[] arr = Files.readAllBytes(new File("/home/roland/Downloads/msc14.11.25508.2_win10_01.11.2017.zip").toPath());
        la1.send(arr,  la2.Address);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("total="+elapsedTime/1000+"   Sekunden");

    }

    @Test
    public void simpleJav(){
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));
       // while (true){}
    }


    @Test
    public void sendBiometruPackage() throws InterruptedException, IOException {
        var sender = new echoJAKtor();
        sender.setAddress("http://127.0.0.1:12121/");
        sender.spawn();
        String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns2=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1\"><S:Body><ns2:SendRequestRequest><ns:SenderProvidedRequestData xmlns:ns=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:ns2=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/basic/1.1\" Id=\"SIGNED_BY_CONSUMER\"><ns:MessageID>2a8a7283-f956-11e8-8cad-b3a33234ec55</ns:MessageID><ns2:MessagePrimaryContent><bm:RegisterBiometricDataRequest xmlns:bm=\"urn://x-artefacts-nbp-rtlabs-ru/register/1.2.0\">\n" +
                "    <bm:RegistrarMnemonic>TEST01</bm:RegistrarMnemonic>\n" +
                "    <bm:EmployeeId>123-456-789 00</bm:EmployeeId>\n" +
                "    <bm:BiometricData>\n" +
                "        <bm:Id>ID-1</bm:Id>\n" +
                "        <bm:Date>2017-07-31T16:54:52+03:00</bm:Date>\n" +
                "        <bm:RaId>0c2c345f-cd7b-4011-9f3b-65095ab4c186</bm:RaId>\n" +
                "        <bm:PersonId>240631324</bm:PersonId>\n" +
                "        <bm:IdpMnemonic>ESIA</bm:IdpMnemonic>      \n" +
                "        <bm:Data>\n" +
                "            <bm:Modality>SOUND</bm:Modality>\n" +
                "            <bm:AttachmentRef attachmentId=\"ef37b493-e94f-4f27-9e86-f4cd80f1057f\"/>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_1_start</bm:Key>\n" +
                "                <bm:Value>00.000</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_1_end</bm:Key>\n" +
                "                <bm:Value>10.002</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_1_desc</bm:Key>\n" +
                "                <bm:Value>digits_asc</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_2_start</bm:Key>\n" +
                "                <bm:Value>12.601</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_2_end</bm:Key>\n" +
                "                <bm:Value>20.199</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_2_desc</bm:Key>\n" +
                "                <bm:Value>digits_desc</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_3_start</bm:Key>\n" +
                "                <bm:Value>22.001</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_3_end</bm:Key>\n" +
                "                <bm:Value>30.102</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "            <bm:BioMetadata>\n" +
                "                <bm:Key>voice_3_desc</bm:Key>\n" +
                "                <bm:Value>digits_random</bm:Value>\n" +
                "            </bm:BioMetadata>\n" +
                "        </bm:Data>\n" +
                "        <bm:Data>\n" +
                "            <bm:Modality>PHOTO</bm:Modality>\n" +
                "            <bm:AttachmentRef attachmentId=\"397af8d0-d456-4dc1-9353-1d6822a02200\"/>\n" +
                "        </bm:Data>\n" +
                "    </bm:BiometricData>\n" +
                "    <bm:BiometricData>\n" +
                "        <bm:Id>ID-2</bm:Id>\n" +
                "        <bm:Date>2017-07-31T16:50:16+03:00</bm:Date>\n" +
                "        <bm:RaId>0c2c345f-cd7b-4011-9f3b-65095ab4c186</bm:RaId>\n" +
                "        <bm:PersonId>215979546</bm:PersonId>\n" +
                "        <bm:IdpMnemonic>ESIA</bm:IdpMnemonic>\n" +
                "        <bm:Data>\n" +
                "            <bm:Modality>FINGERPRINT</bm:Modality>\n" +
                "            <bm:AttachmentRef attachmentId=\"acf4bf60-af0f-4479-a338-d3410e532bf5\"/>\n" +
                "        </bm:Data>\n" +
                "    </bm:BiometricData>\n" +
                "</bm:RegisterBiometricDataRequest></ns2:MessagePrimaryContent><ns:TestMessage/></ns:SenderProvidedRequestData><ns4:CallerInformationSystemSignature xmlns:ns4=\"urn://x-artefacts-smev-gov-ru/services/message-exchange/types/1.1\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><ds:Signature Id=\"sigID\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><ds:SignedInfo><ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/><ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411\"/><ds:Reference URI=\"#SIGNED_BY_CONSUMER\"><ds:Transforms><ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"/><ds:Transform Algorithm=\"urn://smev-gov-ru/xmldsig/transform\"/></ds:Transforms><ds:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#gostr3411\"/><ds:DigestValue>fQ+GpBJFO9rJKDIwM6okI0RrnKjUfT6+zb1W0pnsudE=</ds:DigestValue></ds:Reference></ds:SignedInfo><ds:SignatureValue>MMHgGq1Cwl3CBxkmM11BfI8/M/GrjgUaAXqfkHaei44vaDhiHGNx2L5oyEWoSGONmos7tE9wX8FrpvZze80fAQ==</ds:SignatureValue><ds:KeyInfo><ds:X509Data><ds:X509Certificate>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</ds:X509Certificate></ds:X509Data></ds:KeyInfo></ds:Signature></ns4:CallerInformationSystemSignature></ns2:SendRequestRequest></S:Body></S:Envelope>";
        String operator = "ebs";


        MessageSMEV msg = new MessageSMEV();
        msg.Id="0000";
        msg.pseudo=operator;
        msg.byteToWork =message.getBytes();

        sender.send(MessageSMEV.saveMessageSMEV(msg),"http://127.0.0.1:20000/");//);");//receiver.Address);

        Thread.sleep(2500);


    }

}