

import javax.swing.JOptionPane;

public class currency {

    private String currencyName;
    private double currencyValue = 0;
    private double conversionRatio = 0;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        if (this.currencyValue + currencyValue < 0) {
            JOptionPane.showMessageDialog(null, "Insufficient amount: " + this.getCurrencyName() + " " + (this.currencyValue + currencyValue));
        } else {
            this.currencyValue = this.currencyValue + currencyValue;
        }
    }

    public double getConversionRatio() {
        return conversionRatio;
    }

    public void setConversionRatio(double conversionRatio) {
        this.conversionRatio = conversionRatio;
    }

    public currency() {
    }

}
