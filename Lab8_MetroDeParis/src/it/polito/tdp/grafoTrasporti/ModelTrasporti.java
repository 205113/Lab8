package it.polito.tdp.grafoTrasporti;

import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.WeightedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class ModelTrasporti {
	
	private WeightedGraph<Fermata,DefaultWeightedEdge> grafo;
	
	public void generaMetro() {
		// Genera grafo
		grafo= new SimpleWeightedGraph<Fermata,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		ModelTrasportiDAO m= new ModelTrasportiDAO();
		List<Fermata> fermate= m.fermate();
		List<Linea>linee= m.linee();
		Graphs.addAllVertices(this.grafo, fermate);
		for(Linea linea:linee){
			for(Fermata fermata: fermate){
				for(int i=0;i<fermate.size();i++){
						if(m.collegate(fermata, fermate.get(i), linea)){
							grafo.addEdge(fermata, fermate.get(i));
							grafo.setEdgeWeight(grafo.getEdge(fermata, fermate.get(i)),peso(linea,fermata,fermate.get(i)));
						}
				}
			}
		}

	}

	private double peso(Linea linea, Fermata fermata, Fermata fermata2) {
		// Restituisce il peso del collegamento
		return 1;
	}

	public List<Fermata> percorso(Fermata partenza,Fermata arrivo) {

		// Restituisce il percorso
		DijkstraShortestPath<Fermata,DefaultWeightedEdge> d=new DijkstraShortestPath(this.grafo,partenza,arrivo);
		if(d.getPath()!=null)
			return Graphs.getPathVertexList(d.getPath());
		else
			return null;
	}
public List<Fermata> fermate(){
	ModelTrasportiDAO m=new ModelTrasportiDAO();
	return m.fermate();
}
}
