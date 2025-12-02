#!/bin/bash


echo "🔄 Pulling repo updates (git pull origin main)..."
git pull origin main
echo


# List of subtree imports: prefix remote branch
# Add more lines if you have multiple subtrees
subtrees=(
    "abgabe/gitlab_abgabe gitlab main"
)

echo "Updating all git subtrees..."
echo

for entry in "${subtrees[@]}"; do
    set -- $entry
    prefix=$1
    remote=$2
    branch=$3

    echo "➡ Pulling subtree $remote/$branch into $prefix ..."
    git subtree pull --prefix="$prefix" "$remote" "$branch" --squash
    echo
done

echo "✔ All subtrees updated."

