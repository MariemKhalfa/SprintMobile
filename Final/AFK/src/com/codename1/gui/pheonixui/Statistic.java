/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  com.codename1.gui.pheonixui;
import com.codename1.Entite.Activite;
import com.codename1.Service.ServiceActivite;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author esprit
 */
public class Statistic {
    
     /**
 * Creates a renderer for the specified colors.
 */
     int total=0;
        public Form f;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}

/**
 * Builds a category series using the provided values.
 *
 * @param titles the series titles
 * @param values the values
 * @return the category series
 */
protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);

    
    int k = 0;
    for (double value : values ) {
        series.add("Activite " + ++k, value);
    }

    return series;
   
}

public Form createPieChartForm() {
   // double[] values;
    // Generate the values
    ServiceActivite sr=new ServiceActivite();
      ArrayList<Activite> listProduits = sr.listActivite();
  // listProduits=sr.getList2();
 

      
       double values[] = new double [listProduits.size()] ;

          for(Activite l:listProduits)
           {
                
               total+=l.getId();
               System.out.println(listProduits.indexOf(l));
              
           values[listProduits.indexOf(l)]=l.getId();
           }

       System.out.println(total); 
        System.out.println(values[1]);
  //  double[] values = new double[]{10,30,60, 40};

    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.BLACK,ColorUtil.GREEN,ColorUtil.LTGRAY};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset("Project budget",values), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
    Form f = new Form("Top list", new BorderLayout());
    f.add(BorderLayout.CENTER, c);
    return f;

}   
    
}