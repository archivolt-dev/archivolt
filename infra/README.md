# Local infrastructure

Everything needed for local development, started with Docker Compose from the repository root.

## Start

```bash
cp infra/.env.example infra/.env          # once; change the password if you like (min. 8 characters)
docker compose -f infra/docker-compose.yml up -d
```

- Neo4j Browser: <http://localhost:7474> (user `neo4j`, password from `infra/.env`)
- Bolt: `bolt://localhost:7687`

Ports are bound to `127.0.0.1` only.

Check that APOC is loaded:

```bash
docker compose -f infra/docker-compose.yml exec neo4j \
  cypher-shell -u neo4j -p "<password>" "RETURN apoc.version();"
```

## Profiles

| Profile | Service | Status |
|---|---|---|
| (default) | Neo4j Community + APOC | ready |
| `ai` | Ollama | placeholder, configured in AL-055 |
| `gitops` | Gitea | placeholder, configured in AL-063 |

```bash
docker compose -f infra/docker-compose.yml --profile ai up -d
```

## Stop and reset

```bash
docker compose -f infra/docker-compose.yml down        # stop, keep data
docker compose -f infra/docker-compose.yml down -v     # stop and delete all data volumes
```
