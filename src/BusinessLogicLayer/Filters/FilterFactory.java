/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Filters;
 import BusinessLogicLayer.Common.Cell;
 /**
 *
 * @author MarcoSequeira-PC
 */
public class FilterFactory {
    public static Filter getFilter(String type, Cell cell) {
        switch (type) {
            case "uppercase":
                return new UppercaseFilter(cell);
            case "equal":
                return new EqualFilter(cell);
            case "positive":
                return new PositiveFilter(cell);
            case "negative":
                return new NegativeFilter(cell);
            case "minor":
                return new MinorFilter(cell);
            case "more":
                return new MoreFilter(cell);
            default:
                return null;
        }
    }
}