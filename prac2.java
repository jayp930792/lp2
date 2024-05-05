def aStarAlgo(start_node, stop_node):
open_set = set([start_node])
closed_set = set()
g = {}  # store distance from starting node
parents = {}  # parents contains an adjacency map of all nodes

# distance of starting node from itself is zero
g[start_node] = 0
# start_node is root node, so it has no parent nodes
# thus start_node is set to its own parent node
parents[start_node] = start_node

while len(open_set) > 0:
    n = None
    # node with lowest f() is found
    for v in open_set:
        if n == None or g[v] + heuristic(v) < g[n] + heuristic(n):
            n = v

    if n == None:
        print('Path does not exist!')
        return None

    # if the current node is the stop_node, then we begin reconstructing the path
    if n == stop_node:
        path = []
        while parents[n] != n:
            path.append(n)
            n = parents[n]
        path.append(start_node)
        path.reverse()
        print('Path found: {}'.format(path))
        return path

    # remove n from the open_set, and add it to closed_set
    open_set.remove(n)
    closed_set.add(n)

    if n in Graph_nodes:
        for (m, weight) in get_neighbors(n):
            # nodes 'm' not in first and last set are added to first
            if m not in open_set and m not in closed_set:
                open_set.add(m)
                parents[m] = n
                g[m] = g[n] + weight
            else:
                if g[m] > g[n] + weight:
                    # update g(m)
                    g[m] = g[n] + weight
                    # change parent of m to n
                    parents[m] = n
                    if m in closed_set:
                        # remove m from closed_set and add it to open_set
                        closed_set.remove(m)
                        open_set.add(m)
print('Path does not exist!')
return None

# define function to return neighbor and its distance from the passed node
def get_neighbors(v):
if v in Graph_nodes:
    return Graph_nodes[v]
else:
    return None

# for simplicity we'll consider heuristic distances given and this function returns heuristic distance for all nodes
def heuristic(n):
H_dist = {
    'A': 11,
    'B': 6,
    'C': 99,
    'D': 1,
    'E': 7,
    'G': 0,
}
return H_dist[n]

# Describe your graph here
Graph_nodes = {
'A': [('B', 2), ('E', 3)],
'B': [('C', 1), ('G', 9)],
'C': None,
'E': [('D', 6)],
'D': [('G', 1)],
}
