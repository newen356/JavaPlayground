https://github.com/newen356/JavaPlayground/releases

# JavaPlayground — OOP, Algorithms & Backend Practice Projects ☕️📦

[![Releases](https://img.shields.io/badge/Releases-Download-blue?logo=github)](https://github.com/newen356/JavaPlayground/releases)

![Java Logo](https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg)

Tags: algorithms · backend-development · coding-practice · data-structures · intellij-idea · java · leetcode-solutions · oop · software-engineering · system-design

About this repository
- A collection of Java backend practice projects and coding exercises.
- Focus areas: core OOP, algorithms, data structures, backend patterns, small system design cases.
- Use this repo to learn patterns, run examples, and test ideas in a local dev environment.

Releases
- Download the release asset called JavaPlayground-latest.jar from the releases page and execute it to run the demo suite and sandbox runners.
- Releases page: https://github.com/newen356/JavaPlayground/releases
- The JAR contains runnable demos, sample REST endpoints, and a CLI tool that runs selected exercises.
- Run the downloaded JAR:
  - java -jar JavaPlayground-latest.jar
  - The CLI accepts flags to run a specific module, e.g. java -jar JavaPlayground-latest.jar --module=algorithms/graph
- If you cannot access the link or the file, check the Releases section on the repo page for available assets and instructions.

Table of contents
- Badges
- Structure
- Core projects and exercises
- Algorithms and data structures index
- Backend patterns and microservices
- Sample APIs and endpoints
- System design exercises
- How to build and run
- IDE tips (IntelliJ)
- Testing strategy
- CI / CD and automation
- Coding style and guidelines
- How to contribute
- Issue and PR workflow
- License and contact
- References and images

Badges
- Build: [![Build](https://img.shields.io/badge/build-maven-brightgreen)](https://github.com/newen356/JavaPlayground/actions)
- Tests: [![Tests](https://img.shields.io/badge/tests-junit-blue)](https://github.com/newen356/JavaPlayground/actions)
- Java: [![Java](https://img.shields.io/badge/java-17-orange)](https://openjdk.org)
- Releases: [![Releases](https://img.shields.io/badge/Releases-Download-blue?logo=github)](https://github.com/newen356/JavaPlayground/releases)

Repository structure
- /algorithms
  - Classic algorithm implementations and explainers.
  - Subfolders: sorting, searching, graph, dynamic-programming, greedy.
- /data-structures
  - Custom implementations: linked-lists, trees, heaps, tries, hashmaps.
- /backend
  - Small services and patterns: auth-service, product-service, gateway, event-bus demo.
- /projects
  - Full small projects: todo-app, file-indexer, chat-demo, metrics-collector.
- /exercises
  - LeetCode-style exercises with tests and solutions.
- /docs
  - Design notes, diagrams, and patterns.
- /tools
  - CLI utilities, runners, and shell helpers.
- /scripts
  - Build and test helpers, Dockerfiles, compose files.
- pom.xml / build.gradle
  - Multi-module build config (Maven primary; Gradle alternative available).
- README.md
  - This file.

Core projects and exercises (detailed)
- Practice modules
  - OOP Basics
    - Classes and inheritance exercises.
    - Interfaces and composition demos.
    - SOLID pattern examples implemented in small scenarios.
    - Example: Shape hierarchy with dynamic dispatch, factory, and visitor pattern.
  - Collections and Generics
    - Custom generic collections.
    - Iterator patterns and performance notes.
    - Example: CircularBuffer<T> for producer-consumer patterns.
  - Concurrency
    - Thread basics, locks, executors.
    - Producer-consumer, barriers, latches, and atomic counters.
    - Example: BoundedBlockingQueue with ReentrantLock and Condition.
  - Networking
    - Basic HTTP server built with lightweight library.
    - WebSocket demo for chat and streaming.
    - Example: simple REST API exposing a todo list in-memory.
  - Persistence
    - JDBC usage, in-memory H2 demos, basic JPA mapping.
    - Example: small product inventory with CRUD and pagination.
  - Testing
    - Unit tests (JUnit 5), mocking (Mockito), property tests, and integration tests.
    - Example: test containers to run H2 and localstack for S3 emulation.
  - Performance
    - Benchmarks with JMH.
    - Profiling notes and memory leak examples.
    - Example: compare string concatenation strategies and data structure access patterns.

Algorithms and data structures index
- Sorting
  - Implementations: quicksort, mergesort, heapsort, insertion, selection.
  - Stability notes and when to use each.
  - Time/space complexity table included in docs.
- Searching
  - Binary search variants, interpolation search, ternary search for unimodal functions.
- Graphs
  - Adjacency list and matrix implementations.
  - BFS, DFS, Dijkstra, Bellman-Ford, A* and topological sort.
  - Sample graph problems with step-by-step debug output.
- Dynamic programming
  - Memoization patterns, bottom-up DP, and space optimization.
  - Classic exercises: knapSack, longest increasing subsequence, edit distance.
- Greedy
  - Scheduling, interval scheduling, Huffman coding demo.
- Trees
  - Binary search tree, AVL, red-black simplified, segment tree, Fenwick tree.
- Heaps and priority queues
  - Binary heap, pairing heap demo, and use cases.
- Tries and suffix structures
  - Trie for prefix matching, suffix array introduction.
- Hashing
  - Hash map internals, open addressing vs chaining.
- Complexity written in plain language and small charts.

Backend patterns and microservices
- Architecture examples
  - Layered architecture: controller, service, repository layers.
  - Hexagonal architecture examples with ports and adapters.
  - Event-driven microservice pattern using a local in-memory event bus.
- Service examples
  - Auth service
    - JWT-based auth demo and token refresh flow.
    - Role-based access checks.
  - Product service
    - CRUD with pagination and filtering.
    - Soft delete and audit fields.
  - Gateway
    - Lightweight reverse proxy example and request routing.
    - Rate-limiter example and circuit breaker stub.
- Inter-service communication
  - Synchronous HTTP with RestTemplate or HttpClient.
  - Asynchronous messaging using a simple local queue and sample Kafka-like API.
- Observability
  - Metrics with Micrometer example and Prometheus scrape config in /scripts.
  - Logging patterns and correlation-id propagation across services.
- Deployment
  - Dockerfile for each service.
  - docker-compose sample to bring up product-service, auth-service, and a local gateway.
  - Health endpoints and readiness checks.

Sample APIs and endpoints
- ProductService (HTTP)
  - GET /api/products?page=1&size=10
  - GET /api/products/{id}
  - POST /api/products { name, price, tags[] }
  - PUT /api/products/{id}
  - DELETE /api/products/{id}
- AuthService
  - POST /api/auth/login { username, password } -> { token, refreshToken }
  - POST /api/auth/refresh { refreshToken } -> { token }
  - GET /api/auth/me (requires token)
- Event example
  - POST /api/events { type, payload } pushes event into local bus.
  - WebSocket /ws/stream emits events in real time.
- Sample request/response examples and curl commands available in /docs/api-examples.md

System design exercises
- Small-case designs
  - Design a URL shortener
    - Storage choices, hashing and collision handling, scaling notes.
    - Example implementation with Redis-like in-memory store.
  - Design a simple message queue
    - Delivery semantics, message ordering, at-least-once vs at-most-once.
    - Implementation using persistent queue file for durability.
  - Design a metrics collector
    - Aggregation and downsampling, retention policies, and query interface.
    - Sample collector that batches metrics and exposes a query API.
  - Design a search index
    - Inverted index basics, tokenization, simple ranking.
    - Demo that indexes text files in /projects/file-indexer.
- Architecture patterns
  - CQRS example splitting read and write paths for a demo service.
  - Saga pattern sample for multi-step transaction demo with compensating actions.
- Diagrams
  - System flow diagrams in /docs/diagrams.svg and PNG formats.
  - Example architecture image included below.

![Architecture Diagram](https://miro.medium.com/max/1400/1*7w1iQ2q7Z4VEuG71p2f3ZQ.png)

How to build and run
- Requirements
  - JDK 17 or later.
  - Maven 3.6+ (or Gradle if you prefer, see /build-gradle branch).
  - Docker (optional for services).
- Clone
  - git clone https://github.com/newen356/JavaPlayground.git
  - cd JavaPlayground
- Build (Maven)
  - mvn clean install -DskipTests=false
  - The build produces modules and a runnable JAR in /target.
- Run a single module
  - cd algorithms
  - mvn exec:java -Dexec.mainClass="com.example.algorithms.Runner" -Dexec.args="--problem=graph"
- Run the multi-module runnable JAR
  - After top-level mvn package, run:
    - java -jar tools/runner/target/JavaPlayground-runner-1.0.0.jar --module=projects/todo
- Docker
  - docker-compose -f scripts/docker-compose.yml up
  - This brings up product-service, auth-service, and a simple gateway.
- Run tests
  - mvn test
  - Individual module tests: cd backend/product-service && mvn test
- JMH benchmarks
  - cd benchmarks && mvn clean install
  - mvn -pl benchmarks exec:exec -Dexec.args="-bm sample -wi 3 -i 5"

IntelliJ IDEA tips
- Open the repo as a Maven project.
- Enable annotation processors if using Lombok or MapStruct (project uses Lombok in some modules).
- Run configurations
  - Create a Maven run configuration to run a module with exec plugin.
  - Create application run configs for main classes in each module.
- Debugging
  - Set breakpoints in tests and run with the debugger.
  - Use Evaluate Expression pane for quick checks.
- Code style
  - Import the style file at /docs/intellij-java-style.xml.
  - Enable “Reformat on save” with the file watchers plugin for consistent formatting.

Testing strategy
- Unit tests
  - JUnit 5 for fast unit tests.
  - Use Mockito for behavior verification.
  - Keep unit tests small and deterministic.
- Integration tests
  - Use Spring Boot test slices for service-level integration where applicable.
  - Use Testcontainers for database-backed integration tests when available.
- End-to-end
  - Docker compose based smoke tests that validate service interactions.
- Property-based tests
  - Use jqwik or junit-quickcheck for random input tests in algorithms folder.
- Coverage
  - Use JaCoCo plugin for coverage reports.
  - Aim for meaningful coverage; prefer important logic over boilerplate.

CI / CD and automation
- Example GitHub Actions workflows in .github/workflows
  - build.yml: runs mvn -DskipTests=false on push.
  - test.yml: runs full test suite on PR.
  - release.yml: creates GitHub Release and uploads JAR artifacts on tag.
- Release artifacts
  - Releases include compiled JAR and README changelog.
  - See releases page: https://github.com/newen356/JavaPlayground/releases
- Release automation
  - Use semantic version tags: v1.2.0
  - The workflow packages the runnable JAR and pushes to GitHub Releases.

Coding style and guidelines
- Language
  - Java 17 features used selectively: records, var, enhanced switch.
- Formatting
  - 4-space indent, 120-char soft limit.
  - Line wrap at method chains for readability.
- Naming
  - Use nouns for classes, verbs for methods.
  - Prefer descriptive names over abbreviations.
- Tests
  - Method names describe behavior: shouldReturnEmptyListWhenNoItems()
- Documentation
  - Document public modules and APIs with Javadoc where useful.
  - Keep README in each module short and focused.
- Commit messages
  - Use imperative present tense: "Add binary search implementation"
  - Prefix with scope for clarity: "algorithms: add quicksort explanation"

How to contribute
- Pick an issue labeled "good first issue" or add a feature request.
- Follow the branch naming convention:
  - feature/<short-description>
  - fix/<issue-number>-<short-description>
- Create a fork, implement changes, run tests locally, and open a pull request.
- PR checklist
  - Code compiles and tests pass.
  - Add or update tests for new behavior.
  - Update docs or README as needed.
  - Link the issue in the PR description.
- Review process
  - PRs get at least one reviewer.
  - Keep PRs small and focused.
- Style and linters
  - Run mvn verify to ensure style checks pass.
  - Address all CI comments before merging.

Issue and PR workflow
- Creating issues
  - Use templates located in .github/ISSUE_TEMPLATE to provide a clear report.
  - Include steps to reproduce and expected behavior for bug reports.
- Pull requests
  - Use the PR template in .github/PULL_REQUEST_TEMPLATE.md.
  - Provide a short description and list of changes.
- Labels
  - help wanted, good first issue, enhancement, bug, docs.
- Backports and hotfixes
  - Use hotfix/* branches for urgent bug fixes. Tag with patch version after merge.

Example problems and solutions (samples)
- Problem: Find the longest palindromic substring
  - Approach: Expand around center or use Manacher’s algorithm.
  - Sample code (conceptual):
    - for each center expand left and right while chars match.
    - Track max length and indices.
- Problem: LRU cache
  - Approach: Doubly-linked list + hashmap for O(1) get/put.
  - Tests verify eviction order and usage update on access.
- Problem: Word ladder shortest path
  - Approach: BFS on words graph; build adjacency by wildcard mapping.
  - Use bidirectional BFS for performance on large dictionaries.
- Problem: Rate limiter (token bucket)
  - Approach: Keep last refill timestamp and current tokens. Refill on request.
  - Use synchronized block or atomic long update for thread safety.

Design notes and examples (plain language)
- Why use interfaces for services?
  - Interfaces decouple implementation and allow tests to stub behavior.
- Why choose event-driven design?
  - It improves resilience and allows independent scaling.
- When to use a cache?
  - Cache reads that are expensive and tolerate eventual consistency.
- When to prefer DB transactions vs event compensation?
  - DB transactions work for single-sink operations. For cross-service flows use sagas and compensating actions.

Common pitfalls and how this repo addresses them
- Overcomplicating small examples
  - Keep examples focused and avoid unnecessary frameworks in core exercises.
- Thread-safety bugs
  - Provide both naive and correct implementations to illustrate issues.
- Tests that depend on environment
  - Use in-memory or containerized resources for consistent tests.

Resources and learning map
- Suggested learning path
  - Basics: /algorithms/sorting, /data-structures/linked-list
  - OOP: /projects/shape-suite and /docs/solid-examples.md
  - Backend: /backend/product-service and /backend/auth-service
  - Systems: /projects/file-indexer and system design exercises in /docs
  - Testing and CI: test modules and .github workflows
- External references
  - Java docs: https://docs.oracle.com/en/java/
  - Algorithm books and sites: CLRS, LeetCode, GeeksforGeeks
  - Design patterns: “Design Patterns” (Gang of Four), blogs and diagrams in /docs

Images and diagrams used
- Java logo (Wikipedia)
  - https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg
- Architecture image (example)
  - https://miro.medium.com/max/1400/1*7w1iQ2q7Z4VEuG71p2f3ZQ.png
- Sequence diagrams and flowcharts included in /docs as PNG and SVG files.

Changelog hints
- Release assets include a changelog file that lists new modules and breaking changes.
- Follow semantic versioning for releases.

Sample commands and snippets
- Build and run a module
  - mvn -pl backend/product-service package
  - java -jar backend/product-service/target/product-service.jar
- Run tests in parallel
  - mvn -T 1C test
- Run single test class
  - mvn -Dtest=ProductServiceTest test
- Inspect heap dump
  - jmap -dump:live,format=b,file=heap.hprof <pid>
  - Analyze in VisualVM or YourKit (YourKit is commercial).

Security basics
- Store secrets outside of repo (use environment variables or secrets manager).
- Use HTTPS for inter-service communication in production.
- Validate and sanitize inputs on APIs.
- Use limited permissions for service accounts.

Local dev workflow
- Start supporting services:
  - docker-compose -f scripts/docker-compose.dev.yml up
- Seed data:
  - curl -X POST http://localhost:8080/api/products -d '{"name":"sample", "price":10}'
- Run a specific exercise runner:
  - java -jar tools/runner/target/JavaPlayground-runner-1.0.0.jar --exercise=algorithms/sorting/merge

Community and contact
- Open issues to ask questions or request features.
- Submit PRs for improvements, bug fixes, and new exercises.
- Engage via issues with clear reproduction steps and suggested fixes.

License
- The repository uses the MIT license. See LICENSE file for full terms.

Appendix A — Example code snippets
- Simple BFS template (conceptual)
```java
public List<Node> bfs(Node start) {
    Queue<Node> q = new ArrayDeque<>();
    Set<Node> seen = new HashSet<>();
    List<Node> order = new ArrayList<>();
    q.add(start);
    seen.add(start);
    while (!q.isEmpty()) {
        Node n = q.poll();
        order.add(n);
        for (Node next : n.neighbors()) {
            if (!seen.contains(next)) {
                seen.add(next);
                q.add(next);
            }
        }
    }
    return order;
}
```
- LRU cache skeleton
```java
public class LruCache<K, V> {
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final int capacity;
    private Node<K, V> head, tail;

    public V get(K key) { /* move node to head and return value */ }
    public void put(K key, V value) { /* insert or update and evict if needed */ }

    // internal doubly linked node
    static class Node<K, V> {
        K key; V value; Node<K, V> prev, next;
    }
}
```

Appendix B — Tasks and curriculum ideas
- Week 1: OOP and Collections
  - Implement custom list and map.
  - Create a small class hierarchy with tests.
- Week 2: Algorithms
  - Implement sorts and binary search variants.
  - Solve 10 medium LeetCode problems with tests.
- Week 3: Concurrency and Networking
  - Implement thread-safe queue and small HTTP service.
- Week 4: System design and backend
  - Design a small metrics service, deploy with Docker compose.

Releases (again)
- For the runnable demos, download JavaPlayground-latest.jar from the releases page and execute it:
  - https://github.com/newen356/JavaPlayground/releases
  - Run: java -jar JavaPlayground-latest.jar --module=projects/todo

Files to check after release download
- JavaPlayground-latest.jar
- README-release.md inside the release asset describing run options
- sample-config.yml for runtime flags and ports

References and learning links
- Java language: https://openjdk.org
- JUnit: https://junit.org
- Mockito: https://site.mockito.org
- Micrometer: https://micrometer.io
- Prometheus: https://prometheus.io
- Docker: https://www.docker.com

Images credit
- Java logo: Wikimedia Commons
- Architecture example: Medium article image used as public example

Available support
- Open an issue to request help, explain what you tried and include logs.
- Create feature requests or improvement proposals as issues.

This README provides practical steps, examples, and a learning path to work through backend patterns, algorithms, and system design using Java.