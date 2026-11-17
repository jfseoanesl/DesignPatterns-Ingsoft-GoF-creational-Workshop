#!/usr/bin/env bash
# Compila con javac y ejecuta las clases Demo*. Uso: scripts/ejecutar.sh [filtro]
set -euo pipefail
cd "$(dirname "$0")/.."
OUT=target/classes
JOPTS="-Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8"
mkdir -p "$OUT"
find src/main/java -name '*.java' > target/fuentes.txt
javac --release 17 -encoding UTF-8 -d "$OUT" @target/fuentes.txt
FILTRO="${1:-}"
find src/main/java -name 'Demo*.java' | sort | while read -r f; do
  clase=$(echo "${f#src/main/java/}" | sed 's#/#.#g; s#\.java$##')
  if [[ -z "$FILTRO" || "$clase" == *"$FILTRO"* ]]; then
    echo "=== $clase"
    java $JOPTS -cp "$OUT" "$clase"
    echo
  fi
done
