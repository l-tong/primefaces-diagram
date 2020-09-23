import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

@Named("diagramBasicView")
@ViewScoped
public class BasicView implements Serializable{
     
    private DefaultDiagramModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);
        FlowChartConnector connector = new FlowChartConnector();
        connector.setPaintStyle("{strokeStyle:'#C7B097',lineWidth:1}");
        model.setDefaultConnector(connector);
        int radius = 3;
         
        Element root = new Element("Invention A", "25em", "1em");
        root.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM, radius));
         
        Element patents = new Element("Patents", "25em", "11em");
        patents.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        patents.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM, radius));
        
        Element inventions = new Element("Inventions", "2em", "11em");
        inventions.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        inventions.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM, radius));
        
        Element utlizations = new Element("Utlizations", "45em", "11em");
        utlizations.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        utlizations.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM, radius));
        
        Element elementB = new Element("Patent 1", "10em", "21em");
        elementB.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        elementB.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM, radius));
        
        Element elementC = new Element("Patent 2", "40em", "21em");
        elementC.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        elementC.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM, radius));
        
        Element elementD = new Element("Patent 3", "30em", "31em");
        elementD.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        
        Element element4 = new Element("Patent 4", "45em", "31em");
        element4.addEndPoint(new DotEndPoint(EndPointAnchor.TOP, radius));
        
        model.addElement(root);
        model.addElement(patents);
        model.addElement(inventions);
        model.addElement(utlizations);
        
        model.addElement(elementB);
        model.addElement(elementC);
        model.addElement(elementD);
        model.addElement(element4);
         
        model.connect(new Connection(root.getEndPoints().get(0), patents.getEndPoints().get(0)));        
        model.connect(new Connection(root.getEndPoints().get(0), inventions.getEndPoints().get(0)));
        model.connect(new Connection(root.getEndPoints().get(0), utlizations.getEndPoints().get(0)));
        
        model.connect(new Connection(patents.getEndPoints().get(1), elementB.getEndPoints().get(0)));        
        model.connect(new Connection(patents.getEndPoints().get(1), elementC.getEndPoints().get(0)));
        
        model.connect(new Connection(elementB.getEndPoints().get(1), elementD.getEndPoints().get(0)));
        model.connect(new Connection(elementC.getEndPoints().get(1), elementD.getEndPoints().get(0)));
        
        model.connect(new Connection(elementC.getEndPoints().get(1), element4.getEndPoints().get(0)));
        
        
    }
     
    public DiagramModel getModel() {
        return model;
    }
}
